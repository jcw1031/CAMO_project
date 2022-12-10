package jcw.camo_server.service.file;

import jcw.camo_server.config.FileProperties;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.exception.fileException.FileStorageException;
import jcw.camo_server.exception.fileException.MyFileNotFoundException;
import jcw.camo_server.mapper.CafeMapper;
import jcw.camo_server.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    private final Path fileLocation;
    private final CafeMapper cafeMapper;

    @Autowired
    public FileService(FileProperties fileProperties, CafeMapper cafeMapper) {
        this.fileLocation = Paths.get(fileProperties.getLocation())
                .toAbsolutePath().normalize();
        this.cafeMapper = cafeMapper;

        try {
            Files.createDirectories(this.fileLocation);
        } catch (IOException e) {
            throw new FileStorageException("폴더를 만들 수 없습니다.");
        }
    }

    public String storeFile(MultipartFile file, String cafeId) {
        removeFile(cafeId);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if ((fileName.contains(".."))) {
                throw new FileStorageException("파일 이름 오류(포함 불가 문자) : " + fileName);
            }

            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            String path = this.fileLocation.toString();
            File renameFile = new File(path + "/" + fileName);

            String extension = fileName.substring(fileName.lastIndexOf("."));
            String newName = null;

            if (renameFile.exists()) {
                File newFile = new File(path + "/" + cafeId + extension);
                newName = newFile.getName();
                renameFile.renameTo(newFile);
            }

            Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
            if (optionalCafe.isPresent()) {
                Cafe updateCafe = Cafe.builder()
                        .cafeId(cafeId)
                        .cafeImage(newName).build();
                cafeMapper.cafeImageUpdate(updateCafe);
            }

            return newName;
        } catch (IOException e) {
            throw new FileStorageException("파일을 저장할 수 업습니다! : " + fileName);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("파일을 찾을 수 없습니다!");
            }
        } catch (MalformedURLException e) {
            throw new MyFileNotFoundException("파일을 찾을 수 없습니다!");
        }
    }

    public void removeFile(String cafeId) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        Cafe cafe = null;
        if (optionalCafe.isPresent()) {
            cafe = optionalCafe.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 카페입니다.");
        }

        try {
            File file = new File(fileLocation + "/" + cafe.getCafeImage());
            file.delete();
        } catch (NullPointerException e) {
            throw new NullPointerException("존재하지 않는 파일입니다.");
        }
    }
}

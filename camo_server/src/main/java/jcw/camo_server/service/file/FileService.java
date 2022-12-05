package jcw.camo_server.service.file;

import jcw.camo_server.config.FileProperties;
import jcw.camo_server.exception.fileException.FileStorageException;
import jcw.camo_server.exception.fileException.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    private final Path fileLocation;

    @Autowired
    public FileService(FileProperties fileProperties) {
        this.fileLocation = Paths.get(fileProperties.getLocation())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileLocation);
        } catch (IOException e) {
            throw new FileStorageException("폴더를 만들 수 없습니다.");
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if ((fileName.contains(".."))) {
                throw new FileStorageException("파일 이름 오류(포함 불가 문자) : " + fileName);
            }

            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
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
}
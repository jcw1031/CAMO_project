package jcw.camo_server.controller.file;

import jcw.camo_server.dto.file.UploadFileResponse;
import jcw.camo_server.service.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
@Slf4j
public class FileController {
    private static final String IMAGE_PATH = "C:\\Users\\jcw00\\file\\";

    private final FileService fileService;

    @PostMapping("/upload/{id}")
    public UploadFileResponse uploadFile(@PathVariable("id") String cafeId, @RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file, cafeId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/download/")
                .path(fileName)
                .toUriString();

        return UploadFileResponse.builder()
                .fileName(fileName)
                .fileDownloadUri(fileDownloadUri)
                .fileType(file.getContentType())
                .size(file.getSize())
                .build();
    }

    @GetMapping(
            value = "/download/{fileName:.+}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] downloadFile(@PathVariable("fileName") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(IMAGE_PATH + fileName);
        byte[] imageBytes = inputStream.readAllBytes();
        imageBytes.clone();
        return imageBytes;
    }
}

package jcw.camo_server.service.file;

import jcw.camo_server.config.FileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path fileLocation;

    @Autowired
    public FileService(FileProperties fileProperties) {
        this.fileLocation = Paths.get(fileProperties.getLocation())
                .toAbsolutePath().normalize();

        try {
            Files
        }
    }
}

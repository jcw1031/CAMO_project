package jcw.camo_server.fileTest;


import jcw.camo_server.entity.Cafe;
import jcw.camo_server.mapper.CafeMapper;
import jcw.camo_server.service.file.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {

    @Autowired
    FileService fileService;
    @Autowired
    CafeMapper cafeMapper;

    @Test
    @Transactional
    public void removeTest() {
        String cafeId = "1000000001";
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        Cafe cafe = optionalCafe.get();

        fileService.storeFile(new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {

            }
        }, cafeId);
    }
}

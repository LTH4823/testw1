package org.zerock.boardtest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@Log4j2
public class UploadController {

    @PostMapping("/upload1")
    public void upload1(MultipartFile[] files){

        log.info("==================================");

       log.info(files);

       //업로드된 파일 있다고 가정
        for (MultipartFile file:files) {
            log.info(file.getOriginalFilename());
            log.info(file.getResource());
            log.info("---------------------------");

            try(InputStream in = file.getInputStream();
                FileOutputStream fos = new FileOutputStream("C:\\upload\\"+file.getOriginalFilename());
                ){FileCopyUtils.copy(in,fos);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }//emd for
    }
}

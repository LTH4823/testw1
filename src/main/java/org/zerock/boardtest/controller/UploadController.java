package org.zerock.boardtest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Log4j2
public class UploadController {

    @PostMapping("/upload1")
    public void upload1(MultipartFile[] files){

        log.info("==================================");

       log.info(files);

       //업로드된 파일 있다고 가정
        for (MultipartFile file:files) {

            String originalFileName = file.getOriginalFilename();

            String saveName = UUID.randomUUID().toString()+"_"+originalFileName;

            log.info(file.getResource());
            String saveFolder = makeFolders();

            try(InputStream in = file.getInputStream();
                FileOutputStream fos = new FileOutputStream("C:\\upload\\"+saveFolder+"\\"+saveName);
                ){FileCopyUtils.copy(in,fos);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }//emd for
    }
    private String makeFolders(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String str = sdf.format(new java.util.Date());

        File folderPath = new File("C:\\upload\\" + str);

        if(!folderPath.exists()){
            folderPath.mkdirs();
        }

        return str;

    }

}

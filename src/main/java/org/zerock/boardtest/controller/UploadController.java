package org.zerock.boardtest.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.boardtest.dto.UploadResultDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
public class UploadController {

    @PostMapping("/upload1")
    @ResponseBody
    public List<UploadResultDTO> upload1(MultipartFile[] files) {
        log.info("==================================");

        log.info(files);

        List<UploadResultDTO> list = new ArrayList<>();

        //업로드된 파일 있다고 가정
        for (MultipartFile file : files) {

            String originalFileName = file.getOriginalFilename();

            boolean img = file.getContentType().startsWith("image");

            String uuid = UUID.randomUUID().toString();

            String saveName = uuid + "_" + originalFileName;

            log.info(file.getResource());
            String saveFolder = makeFolders();

            File savaFile = new File("C:\\upload\\" + saveFolder + "\\" + saveName);

            try (InputStream in = file.getInputStream();
                 FileOutputStream fos = new FileOutputStream(savaFile);
            ) {
                FileCopyUtils.copy(in, fos);

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (img) {
                //saveNmae = UUID+"_"+fileName
                String thumbFileName = saveFolder + "\\s_" + saveName;
                File thumFile = new File("C:\\upload\\" + thumbFileName);

                try {
                    Thumbnails.of(savaFile)
                            .size(200, 200)
                            .toFile(thumFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            list.add(UploadResultDTO.builder()
                    .original(originalFileName)
                    .uuid(uuid)
                    .img(img)
                    .savePath(saveFolder)
                    .build());

            log.info("-------------------------------------");

        }//emd for

        return list;
    }

    private String makeFolders() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String str = sdf.format(new java.util.Date());

        File folderPath = new File("C:\\upload\\" + str);

        if (!folderPath.exists()) {
            folderPath.mkdirs();
        }

        return str;

    }

}

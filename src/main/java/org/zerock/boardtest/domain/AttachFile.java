package org.zerock.boardtest.domain;


import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttachFile {

    private String uuid;
    private Integer bno;
    private String fileName;
    private String savePath;
    private boolean img;

    public void setBno(Integer bno){
        this.bno = bno;
    }

}

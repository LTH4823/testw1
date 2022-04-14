package org.zerock.testw1.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
public class BoardDTO {

    private Integer bno;
    private String title;
    private String content;
    private String writer;

    private LocalDateTime reqDate;
    private LocalDateTime updateDate;


}

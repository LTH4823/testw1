package org.zerock.boardtest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BoardDTO {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private int replyCount;

    private LocalDate regDate;
    private LocalDate updateDate;
}

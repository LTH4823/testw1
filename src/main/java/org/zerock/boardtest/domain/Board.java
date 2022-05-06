package org.zerock.boardtest.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private int replyCount;
    private String mainImage;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}

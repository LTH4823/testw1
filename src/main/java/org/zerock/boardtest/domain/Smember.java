package org.zerock.boardtest.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Smember {

    private String mid, mpw,mname,nickname;

    private LocalDateTime reqDate, updateDate;

    @Builder.Default
    private List<Sauth> sauthList = new ArrayList<>();



}

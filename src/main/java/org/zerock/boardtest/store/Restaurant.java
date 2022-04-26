package org.zerock.boardtest.store;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Service
//자동 주입
@RequiredArgsConstructor
public class Restaurant {
    //필드 주입
//    @Autowired
//    private Chef chef;

    // 생성자 주입
//    private final Chef chef;
//
//    public Restaurant(Chef chef) {
//        this.chef = chef;
//    }
   //파이널 + @RequiredArgsConstructor -> 자동 주입
    private final Chef chef;

}

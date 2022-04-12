package org.zerock.testw1.store;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class Restaurant {

    //   @Autowired //지금 부터 객체를 주입해 주어라. 필드주입
    //    private Chef chef; //예전방식

    private final Chef chef; // 요즘방식 자동주입(어노테이션을 사용하여 생성자를 자동 주입)

}

package org.zerock.testw1.store;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository //dao 역할은 보통 Repository 아니면 component 해도 상관 없음
public class KoreanChef implements Chef{

    @Override
    public String cook(){
        return "불고기";
    }
}

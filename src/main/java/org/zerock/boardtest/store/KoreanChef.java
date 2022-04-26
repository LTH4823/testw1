package org.zerock.boardtest.store;

import org.springframework.stereotype.Repository;

//DAO 역할 하는 애들 Repository 보통 줌
@Repository 
public class KoreanChef implements Chef{
    @Override
    public String cook() {
        return "불고기";
    }
}

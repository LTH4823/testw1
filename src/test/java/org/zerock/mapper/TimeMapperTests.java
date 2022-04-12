package org.zerock.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.testw1.mapper.TimeMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    @Autowired(required = false)
    private TimeMapper timeMapper; //초기 에러 라인 이유 -> 빈설정여유를 바로 확인했더니 없어서

    @Test
    public void testNow(){
        log.info("------------------------");
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }
}

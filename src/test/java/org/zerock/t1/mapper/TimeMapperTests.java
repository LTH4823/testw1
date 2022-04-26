package org.zerock.t1.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.boardtest.mapper.TimeMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void testNow(){
        log.info("-----------------");
        //인터페이션 핸들러를 통해 프록시 주소로 생성됨
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

}


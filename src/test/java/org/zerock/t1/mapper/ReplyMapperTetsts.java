package org.zerock.t1.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.boardtest.mapper.ReplyMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class ReplyMapperTetsts {

    @Autowired(required = false)
    public ReplyMapper mapper;


    @Test
    public void testReply(){
            Integer bno =65518;

        mapper.selectListOfBoard(bno).forEach(reply -> log.info(reply));
    }

}

package org.zerock.t1.Service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.boardtest.dto.ReplyDTO;
import org.zerock.boardtest.service.ReplyService;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testInert(){

        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setBno(65517);
        replyDTO.setReplyText("댓글 추가 확인");
        replyDTO.setReplyer("user00");

        replyService.register(replyDTO);

    }

}

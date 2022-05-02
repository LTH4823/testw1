package org.zerock.boardtest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zerock.boardtest.dto.ListDTO;
import org.zerock.boardtest.dto.ReplyDTO;
import org.zerock.boardtest.service.ReplyService;

import java.awt.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/")
    public Map<String, Integer> register(@RequestBody ReplyDTO replyDTO) {
        log.info("=========================");
        log.info(replyDTO);

        int totalCount = replyService.register(replyDTO);

        return Map.of("result", totalCount);
    }

    @GetMapping("/test")
    public String[] get1() {
        return new String[]{"AAA", "BBB", "CCC"};
    }

    @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReplyDTO> getListOfBoard(@PathVariable("bno") Integer bno, ListDTO listDTO) {

        log.info("reply list.." + listDTO);

        return replyService.getListOfBoard(bno, listDTO);
    }

    @DeleteMapping("/{rno}")
    public Map<String, String> remove(@PathVariable("rno") Integer rno){

        log.info("=================================");

        log.info("remove..." + rno);

        replyService.remove(rno);

        return Map.of("result", "success");
    }
}
package org.zerock.boardtest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public Map<String, Integer> register(@RequestBody ReplyDTO replyDTO){
        log.info("=========================");
        log.info(replyDTO);
        return Map.of("result", 135);
    }

    @GetMapping("/test")
    public String[] get(){
        return new String[]{"aaa","bbb","bvvv"};
    }

    @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)// 이 링크로는 어떤 형식의 값이 나올수 잇다
    //produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE >> Json만 만들거여
    public List<ReplyDTO> getListOfBoard(@PathVariable("bno") Integer bno){
        return replyService.getListOfBoard(bno);
    }

}
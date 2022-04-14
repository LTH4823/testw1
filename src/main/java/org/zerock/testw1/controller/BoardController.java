package org.zerock.testw1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.testw1.dto.BoardDTO;


@Log4j2
@Controller
@RequestMapping("/board/")
public class BoardController {

    @GetMapping("/")
    public String basic(){

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list() {
       log.info("board list..........");
    }

    @GetMapping("/register")
    public void registerGET(){
        log.info("board register..........");

    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes rttr){
        log.info("------------------");
        log.info(boardDTO);

        rttr.addFlashAttribute("result",123);
        rttr.addAttribute("result",321);

//        return "redirect:/board/list?result=123";
        return "redirect:/board/list";
    }
}

package org.zerock.testw1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.testw1.dto.BoardDTO;
import org.zerock.testw1.dto.ListDTO;
import org.zerock.testw1.dto.ListResponseDTO;
import org.zerock.testw1.dto.PageMaker;
import org.zerock.testw1.service.BoardService;


import java.util.List;


@Log4j2
@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/")
    public String basic() {

        return "redirect:/board/list";
    }

    @GetMapping("/list")

    //@ModelAttribute(name = "cri") jstl 파라미터 명값 고정가능
    public void list(ListDTO listDTO, Model model) {

        log.info("board list..........");

        log.info(listDTO);

        ListResponseDTO<BoardDTO> responseDTO = service.getList(listDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());

        int total = responseDTO.getTotal();

        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));

    }


    //이 방법을 사용시 파라미터 수치 파악 가능 단 받기만됨 에러잡아야하는쪽은 못 판별함
//    public void list(@RequestParam(name = "page", defaultValue = "1", required = true) int page) {
//
//        log.info("board list..........");
//        log.info("page: "+page);
//    }
//

    @GetMapping("/register")
    public void registerGET() {
        log.info("board register..........");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes rttr) {
        log.info("------------------");
        log.info(boardDTO);

        rttr.addFlashAttribute("result", 123);
        rttr.addAttribute("result", 321);

//        return "redirect:/board/list?result=123";
        return "redirect:/board/list";
    }
}

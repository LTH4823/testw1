package org.zerock.boardtest.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.boardtest.dto.BoardDTO;
import org.zerock.boardtest.dto.ListDTO;
import org.zerock.boardtest.dto.ListResponseDTO;
import org.zerock.boardtest.dto.UploadResultDTO;

import java.util.List;

@Transactional
public interface BoardService {

    //    List<BoardDTO> getList(ListDTO listDTO); //
    void register(BoardDTO boardDTO);

    ListResponseDTO<BoardDTO> getList(ListDTO listDTO);

    BoardDTO getOne(Integer bno);

    void update(BoardDTO boardDTO);

    void remove(Integer bno);

    List<UploadResultDTO> getFiles(Integer bno);

}

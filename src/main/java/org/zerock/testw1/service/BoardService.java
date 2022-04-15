package org.zerock.testw1.service;

import org.zerock.testw1.dto.BoardDTO;
import org.zerock.testw1.dto.ListDTO;
import org.zerock.testw1.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {

    ListResponseDTO<BoardDTO> getList(ListDTO listDTO);


}

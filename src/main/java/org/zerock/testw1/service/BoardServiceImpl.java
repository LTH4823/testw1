package org.zerock.testw1.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.testw1.domain.Board;
import org.zerock.testw1.dto.BoardDTO;
import org.zerock.testw1.dto.ListDTO;
import org.zerock.testw1.dto.ListResponseDTO;
import org.zerock.testw1.mapper.BoardMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;


    @Override
    public ListResponseDTO<BoardDTO> getList(ListDTO listDTO) {

        List<Board> boardList = boardMapper.selectList(listDTO);//listDTO.getSkip(), listDTO.getSize()

        List<BoardDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board,BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }
}

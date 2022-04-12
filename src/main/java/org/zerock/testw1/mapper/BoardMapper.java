package org.zerock.testw1.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.testw1.domain.Board;

import java.util.List;

public interface BoardMapper extends GenericMapper<Board, Integer>{

//    void insert(Board board);
//
////    @Param을 사용하여 파라 미터 사용시 다중으로 xml에 파라미터 제공 가능
//    List<Board> selectList(@Param("skip")int skip,@Param("size")int size);
//
//    void delete(Integer bno);
//
//    Board selectOne(Integer bno);
//
//    void update(Board board);

}

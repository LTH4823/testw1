package org.zerock.testw1.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.testw1.domain.Board;
import org.zerock.testw1.dto.ListDTO;

import java.util.List;

public interface GenericMapper <E,K>{

    void insert(E board);

    //    @Param을 사용하여 파라 미터 사용시 다중으로 xml에 파라미터 제공 가능
    List<Board> selectList(ListDTO listDTO);
                            //@Param("skip")int skip, @Param("size")int size

    int getTotal(ListDTO listDTO);

    void delete(K bno);

    Board selectOne(K bno);

    void update(E board);

}

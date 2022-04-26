package org.zerock.boardtest.mapper;


import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

//    TimeMapper.xml을 보면 만들어져있음

    //    @Select("select now()") -> 이를 작성하고 하면 자바코드 자체에서 sql을 설정하여 할 수 있다.
    String getTime();
}

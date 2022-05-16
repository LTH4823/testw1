package org.zerock.boardtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.boardtest.domain.Sauth;
import org.zerock.boardtest.domain.Smember;

public interface SmemberMapper {

    @Insert("insert into tbl_smember (mid,mpw,mname,nickname) values (#{mid}, #{mpw}, #{mname}, #{nickname})")
    void register(Smember smember);

    @Insert("insert into tbl_sauth (mid,rolename) values (#{mid}, #{roleName})")
    void addAuth(Sauth sauth);

    Smember selectOne(String mid);

}

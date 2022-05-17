package org.zerock.boardtest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@ToString
public class SmemeberDTO extends User {

    private String mid, mpw, mname, nickname;
    private LocalDateTime reqDate, updateDate;

    public SmemeberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);

        this.mid= username;
        this.mpw = password;

    }



}

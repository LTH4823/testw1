package org.zerock.boardtest.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.boardtest.domain.Smember;
import org.zerock.boardtest.mapper.SmemberMapper;

@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final SmemberMapper smemberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("==============================");
        log.info("==============================");
        log.info(username);

        Smember smember = smemberMapper.selectOne(username);
        log.info(smember);

        log.info("==============================");
        log.info("==============================");

        return null;
    }
}

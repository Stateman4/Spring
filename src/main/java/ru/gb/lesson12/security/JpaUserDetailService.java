package ru.gb.lesson12.security;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.lesson12.dao.security.AccountUserDao;
import ru.gb.lesson12.entity.security.AccountUser;

@Service
@NoArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

 @Autowired
 private AccountUserDao accountUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountUser accountUser = accountUserDao.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username " + username + " not found")
        );
        return accountUser;
    }
}

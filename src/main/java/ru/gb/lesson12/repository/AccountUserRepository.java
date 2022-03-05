package ru.gb.lesson12.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson12.dao.security.AccountUserDao;
import ru.gb.lesson12.dao.security.UserRoleDao;
import ru.gb.lesson12.entity.security.AccountUser;
import ru.gb.lesson12.entity.security.UserRole;

@Component
@Repository
@Transactional
public class AccountUserRepository {

    @Autowired
    private AccountUserDao accountUserDao;

    @Autowired
    private UserRoleDao userRoleDao;


    //Добавление нового пользователя
    public AccountUser addUser(AccountUser accountUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        accountUser.setPassword(bCryptPasswordEncoder.encode(accountUser.getPassword()));//кодировка пароля
        return accountUserDao.save(accountUser);
    }

    //добавление роли для нового пользователя
    public UserRole addUserRole(){
            UserRole userRole = new UserRole();
            userRole.setUserId(Long.valueOf(accountUserDao.findAll().size()));
            userRole.setRoleId(2L);
            return userRoleDao.save(userRole);
    }
}

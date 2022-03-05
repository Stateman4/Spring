package ru.gb.lesson12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson12.entity.security.AccountUser;
import ru.gb.lesson12.repository.AccountUserRepository;

@Service
@RequiredArgsConstructor
public class AccountUserService {
    private final AccountUserRepository accountUserRepository;

    public void addUser(AccountUser accountUser){
        accountUserRepository.addUser(accountUser);
        accountUserRepository.addUserRole();
    }
}

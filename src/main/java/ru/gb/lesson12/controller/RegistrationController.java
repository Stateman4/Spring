package ru.gb.lesson12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.lesson12.entity.Product;
import ru.gb.lesson12.entity.security.AccountUser;
import ru.gb.lesson12.service.AccountUserService;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final AccountUserService accountUserService;

    @GetMapping
    public String registrationForm(Model model){
        AccountUser accountUser = new AccountUser();
        model.addAttribute("user", accountUser);
        return "registration";
    }

    @PostMapping
    public String addUser(AccountUser accountUser) {
//        System.out.println(accountUser.getUsername() + " " + accountUser.getPassword() + " " + accountUser.getFirstname() + " " + accountUser.getLastname());
     //  System.out.println(accountUser.getAuthorities());
        accountUserService.addUser(accountUser);
        return "redirect:/product/all";
    }


}

package com.blogspot.vitrocket.transactions.web;

import com.blogspot.vitrocket.transactions.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VitRocket on 13.05.2018.
 */
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public String accounts() {
        return accountService.findAll().toString();
    }

}

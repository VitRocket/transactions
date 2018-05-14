package com.blogspot.vitrocket.transactions.web;

import com.blogspot.vitrocket.transactions.service.AccountServiceImpl;
import com.blogspot.vitrocket.transactions.web.model.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Controller
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountServiceImpl accountService;

    @GetMapping({"/", "/accounts"})
    public String accounts(Model model) {
        List<AccountDTO> list = AccountDTO.accountsToAccountsDTO(accountService.findAll());
        model.addAttribute("accountsDto", list);
        return "accounts";
    }
}

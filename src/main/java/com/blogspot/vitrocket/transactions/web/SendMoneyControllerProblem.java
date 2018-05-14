package com.blogspot.vitrocket.transactions.web;

import com.blogspot.vitrocket.transactions.service.AccountService;
import com.blogspot.vitrocket.transactions.service.AccountTransactionException;
import com.blogspot.vitrocket.transactions.service.SendMoneyService;
import com.blogspot.vitrocket.transactions.web.form.SendMoneyForm;
import com.blogspot.vitrocket.transactions.web.model.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by VitRocket on 14.05.2018.
 */
@Controller
@RequiredArgsConstructor
public class SendMoneyControllerProblem {

    @Autowired
    @Qualifier("sendMoneyServiceProblem")
    private final SendMoneyService sendMoneyServiceProblem;

    @Autowired
    private final AccountService accountService;

    @GetMapping(value = "/send-money-problem")
    public String showFormTransaction(Model model) {
        List<AccountDTO> list = AccountDTO.accountsToAccountsDTO(accountService.findAll());
        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);
        model.addAttribute("accountsDto", list);
        model.addAttribute("sendMoneyForm", form);
        return "send-money-problem";
    }

    @PostMapping(value = "/send-money-problem")
    public String sendMoneyTransaction(Model model, SendMoneyForm sendMoneyForm) {
        System.out.println("Send Money::" + sendMoneyForm.getAmount());
        try {
            sendMoneyServiceProblem.sendMoney(
                    sendMoneyForm.getFromAccountId(),
                    sendMoneyForm.getToAccountId(),
                    sendMoneyForm.getAmount());
        } catch (AccountTransactionException e) {
            List<AccountDTO> list = AccountDTO.accountsToAccountsDTO(accountService.findAll());
            model.addAttribute("accountsDto", list);
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/send-money-problem";
        }
        return "redirect:/send-money-problem";
    }
}
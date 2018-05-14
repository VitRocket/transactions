package com.blogspot.vitrocket.transactions.web;

import com.blogspot.vitrocket.transactions.service.AccountServiceImpl;
import com.blogspot.vitrocket.transactions.service.AccountTransactionException;
import com.blogspot.vitrocket.transactions.service.SendMoneyServiceTransactions;
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
public class SendMoneyControllerTransaction {

    @Autowired
    @Qualifier("sendMoneyServiceTransactions")
    private final SendMoneyServiceTransactions sendMoneyServiceTransactions;

    @Autowired
    private final AccountServiceImpl accountServiceImpl;

    @GetMapping(value = "/send-money-transactions")
    public String showFormTransaction(Model model) {
        List<AccountDTO> list = AccountDTO.accountsToAccountsDTO(accountServiceImpl.findAll());
        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);
        model.addAttribute("accountsDto", list);
        model.addAttribute("sendMoneyForm", form);
        return "send-money-transactions";
    }

    @PostMapping(value = "/send-money-transactions")
    public String sendMoneyTransaction(Model model, SendMoneyForm sendMoneyForm) {
        System.out.println("Send Money::" + sendMoneyForm.getAmount());
        try {
            sendMoneyServiceTransactions.sendMoney(
                    sendMoneyForm.getFromAccountId(),
                    sendMoneyForm.getToAccountId(),
                    sendMoneyForm.getAmount());
        } catch (AccountTransactionException e) {
            List<AccountDTO> list = AccountDTO.accountsToAccountsDTO(accountServiceImpl.findAll());
            model.addAttribute("accountsDto", list);
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/send-money-transactions";
        }
        return "redirect:/send-money-transactions";
    }

}
package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by VitRocket on 14.05.2018.
 */
@Component
@RequiredArgsConstructor
public class SendMoneyServiceProblem implements SendMoneyService {

    @Autowired
    private final AccountService accountService;

    private void addAmount(Long id, double amount) throws AccountTransactionException {
        Account account = accountService.findById(id);
        if (account == null) {
            throw new AccountTransactionException("Account not found " + id);
        }
        double newBalance = account.getBalance() + amount;
        if (account.getBalance() + amount < 0) {
            throw new AccountTransactionException(
                    "The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
        }
        account.setBalance(newBalance);
        accountService.save(account);
    }

    @Override
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws AccountTransactionException {
        addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);
    }
}

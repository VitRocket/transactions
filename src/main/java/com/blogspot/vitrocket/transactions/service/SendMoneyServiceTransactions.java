package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VitRocket on 14.05.2018.
 */
@Component
@RequiredArgsConstructor
public class SendMoneyServiceTransactions implements SendMoneyService {

    private final AccountService accountService;

    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY)
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
    // Do not catch BankTransactionException in this method.
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = AccountTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws AccountTransactionException {
        addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);
    }
}

package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.dao.AccountRepository;
import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findById(Long id) throws NoSuchElementException {
        return accountRepository.findById(id).orElse(null);
    }

}

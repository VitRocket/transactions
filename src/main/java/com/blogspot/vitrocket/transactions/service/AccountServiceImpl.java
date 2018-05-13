package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.dao.AccountRepository;
import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Service
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
}

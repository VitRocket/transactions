package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.entity.Account;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by VitRocket on 13.05.2018.
 */
public interface AccountService {

    List<Account> findAll();

    void save(Account account);

    Account findById(Long id) throws NoSuchElementException;
}

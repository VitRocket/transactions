package com.blogspot.vitrocket.transactions.service;

import com.blogspot.vitrocket.transactions.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VitRocket on 13.05.2018.
 */
public interface AccountService {

    public List<Account> findAll();

    public void save(Account account);
}

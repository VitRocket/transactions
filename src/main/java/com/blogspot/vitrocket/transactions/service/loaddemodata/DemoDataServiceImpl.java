package com.blogspot.vitrocket.transactions.service.loaddemodata;

import com.blogspot.vitrocket.transactions.dao.AccountRepository;
import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Service
@RequiredArgsConstructor
public class DemoDataServiceImpl implements DemoDataService {

    private final AccountRepository accountRepository;

    @Override
    public void addAccounts() {
        List<Account> list =
                Arrays.asList(new Account("Ivan", 1000), new Account("Mike", 2000));


        Iterable<Account> entities = list;

        for (Account entity : entities) {
            accountRepository.save(entity);
        }

    }
}

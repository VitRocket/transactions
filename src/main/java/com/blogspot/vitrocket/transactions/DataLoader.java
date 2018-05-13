package com.blogspot.vitrocket.transactions;

import com.blogspot.vitrocket.transactions.service.loaddemodata.DemoDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    @Autowired
    private final DemoDataService demoDataService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        demoDataService.addAccounts();
    }
}
package com.blogspot.vitrocket.transactions.service;

/**
 * Created by VitRocket on 14.05.2018.
 */
public interface SendMoneyService {

    void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws AccountTransactionException;

}

package com.blogspot.vitrocket.transactions.service;

/**
 * Created by VitRocket on 14.05.2018.
 */
public class AccountTransactionException extends Exception {

    private static final long serialVersionUID = -3128681006635769411L;

    AccountTransactionException(String message) {
        super(message);
    }

}
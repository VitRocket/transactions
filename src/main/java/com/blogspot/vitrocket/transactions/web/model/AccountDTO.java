package com.blogspot.vitrocket.transactions.web.model;

import com.blogspot.vitrocket.transactions.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by VitRocket on 14.05.2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;
    private String fullName;
    private double balance;

    private static AccountDTO accountToAccountDto(Account account) {
        return new AccountDTO(account.getId(), account.getName(), account.getBalance());
    }

    public static List<AccountDTO> accountsToAccountsDTO(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::accountToAccountDto).collect(Collectors.toList());
    }
}

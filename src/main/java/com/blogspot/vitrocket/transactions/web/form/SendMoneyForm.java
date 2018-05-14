package com.blogspot.vitrocket.transactions.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by VitRocket on 14.05.2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMoneyForm {

    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;

}
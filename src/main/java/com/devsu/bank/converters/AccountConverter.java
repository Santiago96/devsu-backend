package com.devsu.bank.converters;


import com.devsu.bank.generated.api.models.Account;
import com.devsu.bank.generated.api.models.Client;

import java.math.BigDecimal;

public class AccountConverter {


    public static com.devsu.bank.model.Account convertToEntity(Account account) {
        com.devsu.bank.model.Account accountEntity = new com.devsu.bank.model.Account();
        if (account.getNumberAccount() != null) {
            accountEntity.setNumberAccount(Long.valueOf(account.getNumberAccount()));
            accountEntity.setBalance(new BigDecimal(account.getBalance().intValue()));
            accountEntity.setState(accountEntity.isState());
        } else {
            accountEntity.setState(Boolean.TRUE);
        }
        accountEntity.setBalance(new BigDecimal(account.getBalance().intValue()));
        accountEntity.setType(account.getType());

        return accountEntity;

    }

    public static Account convertToExpose(com.devsu.bank.model.Account account) {
        Account accountToExpose = new Account();
        accountToExpose.setNumberAccount(account.getNumberAccount().intValue());
        accountToExpose.setType(account.getType());
        accountToExpose.setBalance(account.getBalance());
        accountToExpose.setState(account.isState());
        accountToExpose.setClient(new Client().name(account.getClient().getName()));

        return accountToExpose;
    }
}

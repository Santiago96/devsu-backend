package com.devsu.bank.services;


import com.devsu.bank.converters.AccountConverter;
import com.devsu.bank.generated.api.models.Account;
import com.devsu.bank.model.Client;
import com.devsu.bank.repositories.AccountRepository;
import com.devsu.bank.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        Client client = clientRepository.findById(Long.valueOf(account.getClient().getId())).orElse(null);
        com.devsu.bank.model.Account accountEntity = AccountConverter.convertToEntity(account);
        accountEntity.setClient(client);
        return AccountConverter.convertToExpose(accountRepository.save(accountEntity));
    }

    public List<Account> getAllAccounts() {
        List<com.devsu.bank.model.Account> accountList = accountRepository.findAll();

        return accountList.stream().map(account -> AccountConverter.convertToExpose(account)).collect(Collectors.toList());
    }
}

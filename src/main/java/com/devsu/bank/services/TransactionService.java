package com.devsu.bank.services;


import com.devsu.bank.converters.TransactionConverter;
import com.devsu.bank.generated.api.models.Transaction;
import com.devsu.bank.model.Account;
import com.devsu.bank.repositories.AccountRepository;
import com.devsu.bank.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction createTransaction(Transaction transaction) {
        Account account = accountRepository.findById(Long.valueOf(transaction.getAccount().getNumberAccount())).orElse(null);
        com.devsu.bank.model.Transaction transactionEntity = TransactionConverter.convertToEntity(transaction);

        transactionEntity.setAccount(account);
        transactionEntity.setClient(account.getClient());
        transactionEntity.setBalanceInitial(account.getBalance());
        transactionEntity.setType(account.getType());

        return TransactionConverter.convertToExpose(transactionRepository.save(transactionEntity));
    }

    public List<Transaction> getAllTransactions() {
        List<com.devsu.bank.model.Transaction> transactionList = transactionRepository.findAll();
        return transactionList.stream().map(transaction -> TransactionConverter.convertToExpose(transaction)).collect(Collectors.toList());
    }
}

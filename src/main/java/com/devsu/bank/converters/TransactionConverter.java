package com.devsu.bank.converters;

import com.devsu.bank.generated.api.models.Account;
import com.devsu.bank.generated.api.models.Transaction;

public class TransactionConverter {
    public static com.devsu.bank.model.Transaction convertToEntity(Transaction transaction) {
        com.devsu.bank.model.Transaction transactionEntity = new com.devsu.bank.model.Transaction();

        transactionEntity.setBalanceInitial(transaction.getBalance());
        transactionEntity.setMovement(transaction.getMovement());

        return transactionEntity;
    }

    public static Transaction convertToExpose(com.devsu.bank.model.Transaction transaction) {
        Transaction transactionToExpose = new Transaction();

        transactionToExpose.setAccount(new Account().numberAccount(transaction.getAccount().getNumberAccount().intValue()));
        transactionToExpose.setType(transaction.getType());
        transactionToExpose.setBalance(transaction.getBalanceInitial());
        transactionToExpose.setState(transaction.isState());
        transactionToExpose.setBalanceTransaction(transaction.getBalanceTransaction());

        transactionToExpose.setMovement(transaction.getMovement().concat(transaction.getBalanceTransaction().toString()));

        return transactionToExpose;
    }
}

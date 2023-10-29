package com.devsu.bank.controllers;

import com.devsu.bank.generated.api.MovimientoApi;
import com.devsu.bank.generated.api.models.Transaction;
import com.devsu.bank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController implements MovimientoApi {

    @Autowired
    private TransactionService transactionService;

    @Override
    public ResponseEntity<List<Transaction>> movimientoGet() {
        return MovimientoApi.super.movimientoGet();
    }

    @Override
    public ResponseEntity<Transaction> movimientoIdGet(Integer id) {
        return MovimientoApi.super.movimientoIdGet(id);
    }

    @Override
    public ResponseEntity<Transaction> movimientoIdPut(Integer id, Transaction transaction) {
        return MovimientoApi.super.movimientoIdPut(id, transaction);
    }

    @Override
    public ResponseEntity<Transaction> movimientoPost(Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }
}
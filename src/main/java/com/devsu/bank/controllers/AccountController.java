package com.devsu.bank.controllers;

import com.devsu.bank.generated.api.CuentaApi;
import com.devsu.bank.generated.api.models.Account;
import com.devsu.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements CuentaApi {

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity<List<Account>> cuentaGet() {
        return CuentaApi.super.cuentaGet();
    }

    @Override
    public ResponseEntity<Void> cuentaIdDelete(Integer id) {
        return CuentaApi.super.cuentaIdDelete(id);
    }

    @Override
    public ResponseEntity<Account> cuentaIdGet(Integer id) {
        return CuentaApi.super.cuentaIdGet(id);
    }

    @Override
    public ResponseEntity<Account> cuentaIdPut(Integer id, Account account) {
        return CuentaApi.super.cuentaIdPut(id, account);
    }

    @Override
    public ResponseEntity<Account> cuentaPost(Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }
}
package com.springtransaction.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
import com.springtransaction.dto.BankAccountRequest;
import com.springtransaction.dto.TransferBalanceRequest;
import com.springtransaction.entity.BankAccount;
import com.springtransaction.service.BankAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank-account")
public class BankAccountController {
    
    @Autowired
    private BankAccountService service;

    @PostMapping
    public BankAccount create(@RequestBody BankAccountRequest request) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUsername(request.getUsername());
        bankAccount.setAccountNumber(request.getAccountNumber());
        bankAccount.setBalance(request.getBalance());
        return service.save(bankAccount);
    }

    @GetMapping
    public Iterable<BankAccount> findAll() {
        return service.findAll();
    }

    @PostMapping("transfer")
    public void transfer(@RequestBody TransferBalanceRequest request) {
        service.transfer(
            request.getSourceBankNumber(),
            request.getTargetBankNumber(),
            request.getAmount()
        );
    }
}

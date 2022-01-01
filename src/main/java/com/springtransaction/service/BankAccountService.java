package com.springtransaction.service;

import javax.transaction.Transactional;

import com.springtransaction.entity.BankAccount;
import com.springtransaction.repository.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankAccountService {
    
    @Autowired
    private BankAccountRepository repository;

    public BankAccount save(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @Cacheable(cacheNames = "bankAccounts")
    public Iterable<BankAccount> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void transfer(String source, String target, double amount) {
        log.info("source: "+source);
        log.info("target: "+target);
        BankAccount sourceAccount = repository.findByAccountNumber(source);
        if (source == null) {
            throw new RuntimeException("Source not valid");
        }
        if (sourceAccount.getBalance() <= amount) {
            throw new RuntimeException("Amount not valid");
        }

        double newSourceBalance = sourceAccount.getBalance() - amount;
        sourceAccount.setBalance(newSourceBalance);
        repository.save(sourceAccount);

        BankAccount targeAccount = repository.findByAccountNumber(target);
        if (targeAccount == null) {
            throw new RuntimeException("Target not valid");
        }

        double newTargetBalance = targeAccount.getBalance() + amount;
        targeAccount.setBalance(newTargetBalance);
        repository.save(targeAccount);
    }
}

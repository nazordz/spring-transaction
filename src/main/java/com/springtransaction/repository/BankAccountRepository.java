package com.springtransaction.repository;

import com.springtransaction.entity.BankAccount;

import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, String>{
    public BankAccount findByAccountNumber(String accountNumber);
}

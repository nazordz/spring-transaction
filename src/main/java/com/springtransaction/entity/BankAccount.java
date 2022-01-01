package com.springtransaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "bank_accounts")
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BankAccount {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String id;

    @Column(nullable = false, name = "account_number", length = 20)
    private String accountNumber;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(precision = 15, scale = 2, nullable = false)
    private double balance;
}

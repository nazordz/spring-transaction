package com.springtransaction.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransferBalanceRequest {
    public String sourceBankNumber;
    public String targetBankNumber;
    public double amount;
}

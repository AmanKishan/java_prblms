package com.helpingduck.banktransferapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private UUID transactionId;
    private TransactionStatus transactionStatus;
    private Date TransactionDate;
    private Long transactionAmt;
    private String desc;
    private String accountInvolved;
}

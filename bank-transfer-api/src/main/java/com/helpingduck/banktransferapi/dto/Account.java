package com.helpingduck.banktransferapi.dto;

import lombok.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@EqualsAndHashCode(of = "accountNumber")
@NoArgsConstructor
public class Account {

    private String accountNumber;

    private String holderName;

    private Bank.Branch branch;

    @Setter
    private AtomicLong balance ;

    @Setter
    private long minBalance;

    private boolean active;

    public Account(String holderName, Bank.Branch branch, long initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.holderName = holderName;
        this.branch = branch;
        this.minBalance = initialBalance;
        this.active = true;
        this.balance = new AtomicLong(this.minBalance);
    }

    private String generateAccountNumber(){
        ThreadLocalRandom rand =  ThreadLocalRandom.current();
        return  String.format(
                "%04d-%04d-%04d-%04d",
                rand.nextInt(100),
                rand.nextInt(10000),
                rand.nextInt(10000),
                rand.nextInt(10000));
    }
}

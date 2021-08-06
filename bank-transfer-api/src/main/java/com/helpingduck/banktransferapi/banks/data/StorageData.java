package com.helpingduck.banktransferapi.banks.data;

import com.helpingduck.banktransferapi.dto.Bank;
import com.helpingduck.banktransferapi.dto.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class StorageData {

    public static Map<String,Bank> BANK_INFO;

    public static Map<String, CopyOnWriteArrayList<Transaction>> TRANSACTIONS_INFO;

    static {
        BANK_INFO = new ConcurrentHashMap<>();
        Bank bank1 = new Bank("SBI","State Bank Of India");
        Bank.Branch sbibranch1 = new Bank.Branch("001SBI","SBI","Moradabad city");
        Bank.Branch sbibranch2 = new Bank.Branch("005SBI","SBI","Lucknow city");
        bank1.getBranches().add(sbibranch1);
        bank1.getBranches().add(sbibranch2);

        BANK_INFO.put("SBI",bank1);

        Bank bank2 = new Bank("HDFC","Housing Development Finance Corporation Limited ");
        Bank.Branch hdfcbranch1 = new Bank.Branch("005HDFC","HDFC","Delhi city");
        Bank.Branch hdfcbranch2 = new Bank.Branch("002HDFC","HDFC","Mumbai city");
        bank1.getBranches().add(hdfcbranch1);
        bank1.getBranches().add(hdfcbranch2);
        BANK_INFO.put("HDFC",bank2);

        TRANSACTIONS_INFO =  new ConcurrentHashMap<>(); /// key as bank_code + account_no
    }

}

package com.helpingduck.banktransferapi.banks.bankingservice;

import com.helpingduck.banktransferapi.banks.data.StorageData;
import com.helpingduck.banktransferapi.dto.Account;
import com.helpingduck.banktransferapi.dto.Bank;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {


    private  static final AccountService accountService = new AccountService();

    public static AccountService getAccountService(){
            return accountService;
    }

    public Account addAccount(String holderName, String ifsc, String bankCode, long initialBalance){

        final Bank bank = StorageData.BANK_INFO.get(bankCode);
        final Bank.Branch branch = bank.getBranches().stream().filter(bb ->  ifsc.equals(bb.getIfsc()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No branch with ifsc " + ifsc + " exists."));
        final Account account
                 = new Account(holderName,branch,initialBalance);
        StorageData.BANK_INFO.get(bankCode).getAccounts().add(account);
        return account;
    }

    public Long deductAmountFromAccount(final Account account, @NonNull final Long amount) {
        // TODO: better locking mechanism for account level lock, likely maintaining a map of iban vs locks in BankService
        //  For simplicity, as we believe the account being passed is singleton, we are locking on method parameter
        synchronized (account) {
            if(account.getBalance().get() >= amount) {
                return account.getBalance().addAndGet(-amount);
            }
        }
        throw new RuntimeException("Not sufficient balance");
    }

    public Long addAmountToAccount(final Account account, @NonNull final Long amount) {
        return account.getBalance().addAndGet(amount);
    }

    public Account getAccountDetails(String accountNumber,String bankCode){
        final Bank bank = StorageData.BANK_INFO.get(bankCode);
        return bank.getAccounts().stream().filter(acc -> acc.getAccountNumber().equals(accountNumber)).findFirst()
                .orElseThrow(() -> new RuntimeException("No Account for account no " + accountNumber + " exists."));
    }
}

package com.helpingduck.banktransferapi;


import com.helpingduck.banktransferapi.banks.bankingservice.AccountService;
import com.helpingduck.banktransferapi.banks.bankingservice.BankTransferService;
import com.helpingduck.banktransferapi.banks.controller.AccountController;
import com.helpingduck.banktransferapi.dto.Account;

public class BankTransferApp {


    public static void main(String[] args) {

        AccountService accountService = AccountService.getAccountService();
        BankTransferService bankTransferService = new BankTransferService(accountService);

        AccountController accountController = new AccountController(accountService);
        Account SenderAccount  = accountController.addAccount("aman","001SBI","SBI",1000L);
        accountService.addAmountToAccount(SenderAccount,2000L);
        Account receiverAccount = accountController.addAccount("aman","001SBI","SBI",1000L);
        accountService.addAmountToAccount(receiverAccount,1000L);


        bankTransferService.transfer(SenderAccount.getAccountNumber(),
                receiverAccount.getAccountNumber(),
                SenderAccount.getBranch().getBankCode(),
                receiverAccount.getBranch().getBankCode(),
                1000);

        System.out.println("Sender Money "  + accountController.getAccount(SenderAccount.getAccountNumber(),SenderAccount.getBranch().getBankCode()).getBalance());
        System.out.println("Receiver Money "  + accountController.getAccount(receiverAccount.getAccountNumber(),receiverAccount.getBranch().getBankCode()).getBalance());


    }
}

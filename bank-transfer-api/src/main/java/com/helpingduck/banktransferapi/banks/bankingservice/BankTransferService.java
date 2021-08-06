package com.helpingduck.banktransferapi.banks.bankingservice;

import com.helpingduck.banktransferapi.banks.data.StorageData;
import com.helpingduck.banktransferapi.dto.Account;
import com.helpingduck.banktransferapi.dto.Transaction;
import com.helpingduck.banktransferapi.dto.TransactionStatus;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RequiredArgsConstructor
public class BankTransferService {

    private final AccountService accountService;

    public Transaction transfer(String senderAccountNo, String receiverAccountNo,
                         String senderBankCode,String receiverBankCode
              ,long transferAmt){

        Account senderAccount = accountService.getAccountDetails(senderAccountNo,senderBankCode);
        Account receiverAccount = accountService.getAccountDetails(receiverAccountNo,receiverBankCode);

        try{
            Transaction TransferTransaction =
                    Transaction.builder().transactionAmt(transferAmt)
                    .TransactionDate(new Date())
                    .transactionId(UUID.randomUUID())
                            .desc("Transaction initiated")
                    .transactionStatus(TransactionStatus.INTITIATED)
                    .accountInvolved(senderAccount.getAccountNumber()).build();

            updateTransaction(senderBankCode,senderAccountNo,TransferTransaction);

            Long senderAccountBalance = accountService.deductAmountFromAccount(senderAccount,transferAmt);

            Transaction debitTransaction =
                    Transaction.builder().transactionAmt(transferAmt)
                            .TransactionDate(new Date())
                            .transactionId(UUID.randomUUID())
                            .desc("Transaction Debited")
                            .transactionStatus(TransactionStatus.DEBITED)
                            .accountInvolved(senderAccount.getAccountNumber()).build();

            updateTransaction(senderBankCode,senderAccountNo,debitTransaction);

            System.out.println("Amount : " + transferAmt + " is " +TransactionStatus.DEBITED.name() + " from senders account no : " + senderAccount.getAccountNumber()
             + "Old Balance was : " + senderAccount.getBalance() + " new Balance is: " + senderAccountBalance);

            Long receiverAccountBalance = accountService.addAmountToAccount(receiverAccount,transferAmt);

            Transaction creditedTransaction =
                    Transaction.builder().transactionAmt(transferAmt)
                            .TransactionDate(new Date())
                            .transactionId(UUID.randomUUID())
                            .desc("Transaction Credited")
                            .transactionStatus(TransactionStatus.CREDITED)
                            .accountInvolved(receiverAccount.getAccountNumber()).build();

            updateTransaction(receiverBankCode,receiverAccountNo,creditedTransaction);

            System.out.println("Amount : " +transferAmt + " is " +TransactionStatus.CREDITED.name() + " to receiver account no : " + receiverAccount.getAccountNumber()
                    + "Old Balance was : " + receiverAccount.getBalance() + " new Balance is: " + receiverAccountBalance);
            return creditedTransaction;

        }catch(Exception ex){
            Account senderAccountInfo = accountService.getAccountDetails(senderAccountNo,senderBankCode);
            if(senderAccountInfo.getBalance().longValue() !=
                    senderAccount.getBalance().longValue()
            ){
                Transaction revertedTransaction =
                        Transaction.builder().transactionAmt(transferAmt)
                                .TransactionDate(new Date())
                                .transactionId(UUID.randomUUID())
                                .desc("Transaction Reverted to senders account")
                                .transactionStatus(TransactionStatus.REVERTED)
                                .accountInvolved(senderAccount.getAccountNumber()).build();
                updateTransaction(senderBankCode,senderAccountNo,revertedTransaction);
            }else{
                System.out.println("No Need to revert transaction");
            }
            throw new RuntimeException("...");
        }
    }

    private void updateTransaction(String bankCode, String accNo, Transaction tx){

        String key = bankCode+"_"+accNo;
        if(StorageData.TRANSACTIONS_INFO.containsKey(key)){
            StorageData.TRANSACTIONS_INFO.get(key).add(tx);
        }else{
            CopyOnWriteArrayList<Transaction> txs = new CopyOnWriteArrayList<>();
            txs.add(tx);
            StorageData.TRANSACTIONS_INFO.put(key,txs);
        }
    }
}

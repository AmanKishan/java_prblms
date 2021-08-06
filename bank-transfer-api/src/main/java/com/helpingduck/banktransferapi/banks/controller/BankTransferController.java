package com.helpingduck.banktransferapi.banks.controller;

import com.helpingduck.banktransferapi.banks.bankingservice.BankTransferService;
import com.helpingduck.banktransferapi.dto.Account;
import com.helpingduck.banktransferapi.dto.Transaction;
import lombok.RequiredArgsConstructor;

//import javax.ws.rs.*;
//import java.math.BigDecimal;

//import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
public class BankTransferController {

    private final BankTransferService bankTransferService;

    //@POST
    //@Consumes(APPLICATION_JSON)
    //@Produces(APPLICATION_JSON)
    public Transaction transfer(String senderAccountNo, String receiverAccountNo,
                                String senderBankCode, String receiverBankCode
            , long transferAmt){
        return this.bankTransferService.transfer(senderAccountNo,receiverAccountNo,senderBankCode,receiverBankCode,transferAmt);
    }
}

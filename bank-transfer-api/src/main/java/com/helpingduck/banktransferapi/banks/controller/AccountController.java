package com.helpingduck.banktransferapi.banks.controller;

import com.helpingduck.banktransferapi.banks.bankingservice.AccountService;
import com.helpingduck.banktransferapi.dto.Account;
import lombok.RequiredArgsConstructor;

//import javax.ws.rs.*;

//import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
//@Path("/ctofservice")
public class AccountController {

    private final AccountService accountService;

    //@POST
    //@Consumes(APPLICATION_JSON)
    //@Produces(APPLICATION_JSON)
    public Account addAccount(//@PathParam("holderName")
                                          String holderName,
                              //@PathParam("ifsc")
                              String ifsc,
                              //@PathParam("bankCode")
                              String bankCode,
                              //@PathParam("initialBalance")
                              long initialBalance){
        return this.accountService.addAccount(holderName,ifsc,bankCode,initialBalance);
    }

    //@GET
    //@Consumes(APPLICATION_JSON)
    //@Produces(APPLICATION_JSON)
    public Account getAccount(//@PathParam("accountNumber")
                                          String accountNumber,
                              //@PathParam("bankCode")
                              String bankCode){
        return this.accountService.getAccountDetails(accountNumber,bankCode);
    }
}

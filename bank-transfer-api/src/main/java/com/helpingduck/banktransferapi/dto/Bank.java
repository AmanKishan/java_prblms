package com.helpingduck.banktransferapi.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Getter
@EqualsAndHashCode(of = "bankCode")
@NoArgsConstructor
public class Bank implements Serializable {


    private String bankCode;
    private String bankName;

    @Setter
    private Set<Branch> branches;

    @Setter
    private Set<Account> accounts;

    public Bank(String bankCode, String bankName) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.branches = new CopyOnWriteArraySet<>();
        this.accounts = new CopyOnWriteArraySet<>();
    }

    @Builder
    @Getter
    @EqualsAndHashCode(of = "branchCode")
    public static class Branch implements Serializable{

        public Branch(@NonNull String ifsc, @NonNull String bankCode, @NonNull String branchName) {
            this.ifsc = ifsc;
            this.bankCode = bankCode;
            this.branchName = branchName;
        }

        @NonNull
        private String ifsc;

        @NonNull
        private String bankCode;

        @NonNull
        private String branchName;
    }
}

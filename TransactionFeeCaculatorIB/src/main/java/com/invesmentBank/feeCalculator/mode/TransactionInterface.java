package com.invesmentBank.feeCalculator.mode;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFILETYPES;


public interface TransactionInterface {

	public void displayTransactionReport();

	public TransactionInterface readFile(TRANSACTIONFILETYPES fileType);
}

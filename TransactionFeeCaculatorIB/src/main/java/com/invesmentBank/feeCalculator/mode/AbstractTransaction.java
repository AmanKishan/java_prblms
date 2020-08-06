package com.invesmentBank.feeCalculator.mode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFEE;
import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONTYPE;
import com.invesmentBank.feeCalculator.dto.Transaction;
import com.invesmentBank.feeCalculator.util.ApplicationUtil;

public abstract class AbstractTransaction {

	private final Logger log = LoggerFactory.getLogger(AbstractTransaction.class);
	
	public List<Transaction> transactionList;

	public abstract void readTransaction(File file);

	public void saveTransaction(Transaction transaction) {

		log.info("Save Transaction --> " + transaction);
		if (transactionList == null) {
			transactionList = new ArrayList<Transaction>();
		}

		transactionList.add(calculateTransactionFee(transaction));

	}

	private Transaction calculateTransactionFee(Transaction transaction) {

		log.info("Calculation Start Transaction --> " + transaction);
		if (isIntradayTransaction(transaction)) {
			transaction.setTranFee(TRANSACTIONFEE.TEN.getTranFee());
		} else {

			if (transaction.getProrityFlag()) {
				transaction.setTranFee(TRANSACTIONFEE.FIVE_HUNDREAD.getTranFee());

			} else {
				if (transaction.getTranType() == TRANSACTIONTYPE.SELL.getTranType()
						|| transaction.getTranType() == TRANSACTIONTYPE.WITHDRAW.getTranType()) {

					transaction.setTranFee(TRANSACTIONFEE.HUNDREAD.getTranFee());

				} else if (transaction.getTranType() == TRANSACTIONTYPE.BUY.getTranType()
						|| transaction.getTranType() == TRANSACTIONTYPE.DEPOSIT.getTranType()) {

					transaction.setTranFee(TRANSACTIONFEE.FIFTY.getTranFee());
				}

			}

		}
		log.info("Calculation End Transaction --> " + transaction);
		return transaction;
	}

	private boolean isIntradayTransaction(Transaction transaction) {
		log.info("Check Transaction isIntradayTransaction --> " + transaction);
		boolean isIntraDayTransaction = false;
		Transaction temp = null;
		
		if (transactionList.size() > 0) {
			for (Transaction trans : transactionList) {
				if (trans.getClientId().equals(transaction.getClientId())
						&& trans.getSecurityId().equals(transaction.getSecurityId())
						&& trans.getTranDate().equals(transaction.getTranDate())) {
					if ((trans.getTranType() == TRANSACTIONTYPE.BUY.getTranType()
							&& transaction.getTranType() == TRANSACTIONTYPE.SELL.getTranType())
							|| (trans.getTranType() == TRANSACTIONTYPE.SELL.getTranType()
									&& transaction.getTranType() == TRANSACTIONTYPE.BUY.getTranType())) {
						isIntraDayTransaction = true;
						temp = trans;
						break;
					}
				}

			}

			if (temp != null) {
				transactionList.remove(temp);
				temp.setTranFee(TRANSACTIONFEE.TEN.getTranFee());
				transactionList.add(temp);
			}

		} else {
			isIntraDayTransaction = false;
		}

		return isIntraDayTransaction;
	}

	public Transaction getTransaction(String[] transactionAttributes) {
		log.info("Get Transaction attributes --> " + transactionAttributes);
		for (String string : transactionAttributes) {
			System.out.print(" " + string);
		}
		Transaction transaction = new Transaction();
		transaction.setExternalTranId(transactionAttributes[0]);
		transaction.setClientId(transactionAttributes[1]);
		transaction.setSecurityId(transactionAttributes[2]);
		transaction.setTranType(transactionAttributes[3]);
		transaction.setTranDate(ApplicationUtil.parseDate(transactionAttributes[4]));
		transaction.setMarketVal(ApplicationUtil.parseMarketValue(transactionAttributes[5]));
		transaction.setProrityFlag(ApplicationUtil.getPriority(transactionAttributes[6]));
		log.info("Get Transaction --> " + transaction);
		return transaction;
	}

	/**
	 * This method will be display TransactionReport.
	 */
	
	public void displayTransactionReport() {
		
		log.info("Get Transaction report start ");
		Collections.sort(transactionList, new Transaction());
		System.out.println("Calculated Fees For IB's are :-");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |");
		for (Transaction transaction : transactionList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(transaction.getClientId() + "\t| " + transaction.getTranDate() + "\t| "
					+ transaction.getTranDate() + "\t| " + (transaction.getProrityFlag() ? "HIGH\t" : "NORMAL") + "\t| "
					+ transaction.getTranFee() + "\t|");
		}
		System.out.println("--------------------------------------------------------------------------------");
		
		log.info("Get Transaction report start ");
	}

}

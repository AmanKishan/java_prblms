package com.invesmentBank.feeCalculator.mode;

import java.io.File;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFILETYPES;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLTransaction extends AbstractTransaction implements TransactionInterface {

	private final Logger log = LoggerFactory.getLogger(XMLTransaction.class);
	
	@Override
	public void readTransaction(File transactionFile) {
		// TODO Auto-generated method stub

	}

	public TransactionInterface readFile(TRANSACTIONFILETYPES fileType) {
		log.info("Read file as " + fileType);
		if (fileType == TRANSACTIONFILETYPES.CSV) {
			return TransactionModeFactory.getTrasactionModeInstance().readXmlFile();
		}
		return null;
	}

}

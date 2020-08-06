package com.invesmentBank.feeCalculator.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFILETYPES;

public class ExcelTransactionMode extends AbstractTransaction implements TransactionInterface {

	private final Logger log = LoggerFactory.getLogger(ExcelTransactionMode.class);
	
	@Override
	public void readTransaction(File transactionFile) {
		log.info("Read Transaction for Excel");
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(transactionFile));
			while ((line = br.readLine()) != null) {
				String[] transactionAttributes = line.split(cvsSplitBy);
				com.invesmentBank.feeCalculator.dto.Transaction transaction = getTransaction(transactionAttributes);
				saveTransaction(transaction);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public TransactionInterface readFile(TRANSACTIONFILETYPES fileType) {
		log.info("Read file as " + fileType);
		if (fileType == TRANSACTIONFILETYPES.CSV) {
			return TransactionModeFactory.getTrasactionModeInstance().readExcelFile();
		}
		return null;
	}

}

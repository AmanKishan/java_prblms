package com.invesmentBank.feeCalculator.mode;

import java.io.File;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFILETYPES;

public class TransactionModeFactory {

	private static TransactionModeFactory trasactionMode;

	private static ExcelTransactionMode excelTransctionMode;

	private static XMLTransaction xmlTransctionMode;

	private static TextTransactionMode textTransctionMode;

	public static TransactionModeFactory getTrasactionModeInstance() {
		if (null == trasactionMode) {
			synchronized (TransactionModeFactory.class) {
				if (null == trasactionMode) {
					trasactionMode = new TransactionModeFactory();
					excelTransctionMode = new ExcelTransactionMode();
					xmlTransctionMode = new XMLTransaction();
					textTransctionMode = new TextTransactionMode();
				}
			}
		}
		return trasactionMode;
	}

	public ExcelTransactionMode readExcelFile() {
		return excelTransctionMode;
	}

	public XMLTransaction readXmlFile() {
		return xmlTransctionMode;
	}

	public TextTransactionMode readTextFile() {
		return textTransctionMode;
	}

	public TransactionInterface readFile(TRANSACTIONFILETYPES fileType, File transactionFile) {
		switch (fileType) {
		case CSV:
			excelTransctionMode.readTransaction(transactionFile);
			return excelTransctionMode;
		case TEXT:
			textTransctionMode.readTransaction(transactionFile);
			return textTransctionMode;
		case XML:
			xmlTransctionMode.readTransaction(transactionFile);
			return xmlTransctionMode;

		default:
			return null;
		}
	}

}

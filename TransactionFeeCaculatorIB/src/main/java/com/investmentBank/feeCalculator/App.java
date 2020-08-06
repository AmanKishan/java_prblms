package com.investmentBank.feeCalculator;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

import com.invesmentBank.feeCalculator.constant.Constant.TRANSACTIONFILETYPES;
import com.invesmentBank.feeCalculator.mode.TransactionInterface;
import com.invesmentBank.feeCalculator.mode.TransactionModeFactory;

public class App 
{
    public static void main( String[] args )
    {
    	String log4jConfPath = "src/main/resource/log4j/log4j.properties";
    	PropertyConfigurator.configure(log4jConfPath);
    	File transactionfile = new File(new File("").getAbsolutePath(),"src/main/resource/TransactionData.txt");
		TransactionInterface tranction= TransactionModeFactory.getTrasactionModeInstance().readFile(TRANSACTIONFILETYPES.TEXT,transactionfile);		
		tranction.displayTransactionReport();
    }
}

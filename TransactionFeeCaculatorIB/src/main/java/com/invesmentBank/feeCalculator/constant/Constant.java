package com.invesmentBank.feeCalculator.constant;

public class Constant {

	public enum TRANSACTIONFILETYPES  {
		CSV(1),XML(2),TEXT(3),EXCEL(4);
		int fileType;
		TRANSACTIONFILETYPES(int fileType){
			this.fileType= fileType;
		}
		public boolean getValue() {
			return false;
		}
	};
	
	public enum TRANSACTIONTYPE {
		BUY("BUY"),SELL("SELL"),DEPOSIT("DEPOSITE"),WITHDRAW("WITHDRAW");
		
		private String tranType;
		TRANSACTIONTYPE(String tranType) {
			this.tranType = tranType;
		}
		
		public String getTranType() {
			return tranType;
		}
		
	};
	
	public enum TRANSACTIONFEE {		
		TEN(10),FIFTY(50),HUNDREAD(100),FIVE_HUNDREAD(500);
		private double tranFee;
		TRANSACTIONFEE(double tranFee) {
			this.tranFee = tranFee;
		}
		public double getTranFee() {
			return tranFee;
		} 
	};
}

package com.invesmentBank.feeCalculator.dto;

import java.util.Comparator;
import java.util.Date;

public class Transaction implements Comparator<Transaction> {

	private String externalTranId;
	private String clientId;
	private String securityId;
	private String tranType;
	private Date tranDate;
	private Double marketVal;
	private Double tranFee;
	private Boolean prorityFlag;

	public String getExternalTranId() {
		return externalTranId;
	}

	public void setExternalTranId(String externalTranId) {
		this.externalTranId = externalTranId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public Double getMarketVal() {
		return marketVal;
	}

	public void setMarketVal(Double marketVal) {
		this.marketVal = marketVal;
	}

	public Double getTranFee() {
		return tranFee;
	}

	public void setTranFee(Double tranFee) {
		this.tranFee = tranFee;
	}

	public Boolean getProrityFlag() {
		return prorityFlag;
	}

	public void setProrityFlag(Boolean prorityFlag) {
		this.prorityFlag = prorityFlag;
	}

	@Override
	public String toString() {
		return "Transaction [externalTranId=" + externalTranId + ", clientId=" + clientId + ", securityId=" + securityId
				+ ", tranType=" + tranType + ", tranDate=" + tranDate + ", marketVal=" + marketVal + ", tranFee="
				+ tranFee + ", prorityFlag=" + prorityFlag + "]";
	}

	public int compare(Transaction trans1, Transaction trans2) {

		int value1 = trans1.getClientId().compareTo(trans2.getClientId());
		if (value1 == 0) {
			int value2 = trans1.getTranType().compareTo(trans2.getTranType());
			if (value2 == 0) {
				int value3 = trans1.getTranDate().compareTo(trans2.getTranDate());
				if (value3 == 0) {
					return trans1.getProrityFlag().compareTo(trans2.getProrityFlag());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;

	}

}

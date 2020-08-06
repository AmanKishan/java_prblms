package com.invesmentBank.feeCalculator.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationUtil {

	private final static Logger log = LoggerFactory.getLogger(ApplicationUtil.class);
	
	public static Double parseMarketValue(String marketValue) {
		try{
			
			return Double.parseDouble(marketValue);
		}catch(Exception ex){
			 log.error("Exception Error whle parsing value"  + ex);
			return (double) 0;
		}
	}

	public static Boolean getPriority(String priority) {
		if(priority!= null){
			priority = priority.trim();
			if(priority.equals("Y")||priority.equals("y")){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	public static Date parseDate(String date) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			return  sdf.parse(date);
		}catch(Exception  ex){
			log.error("Exception Error while parsing date" + ex);
			return null;
		}
	}


}

package com.java.testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ZoneDateTimeTest {


	final static ZoneId zoneId = ZoneId.of("Europe/Zurich");
	
	public static  String formateDate(ZonedDateTime zDate) {
		
		//DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");
		/*DateFormat dateFormat = new SimpleDateFormat("E dd MMM yyyy h:mm a");
		System.out.println(Date.from(zDate.toInstant()));
		return dateFormat.format(Date.from(zDate.toInstant()));
		*/
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMM yyyy h:mm a");
		String formattedString = zDate.format(formatter);
		return formattedString;

	}
	
	
	public static void main(String[] args) {
	System.out.println("ZonedDateTime.now() "+ ZonedDateTime.now());
	Instant timeStamp= Instant.now();
	ZonedDateTime LAZone= timeStamp.atZone(ZoneId.of("America/Los_Angeles"));
	System.out.println("LOS Angeles " + formateDate(LAZone));
	ZonedDateTime nowInIndia = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	System.out.println(" nowInIndia" + formateDate(nowInIndia));
	ZonedDateTime nowInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
	System.out.println("now in paris" + formateDate(nowInParis));
		ZoneDateTimeTest test  = new ZoneDateTimeTest();
		String tym = "2018-08-06 00:38:21.0";
		String pattern = "yyyy-MM-dd HH:mm:ss.S";
		DateTimeFormatter Parser = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of("UTC"));
		ZonedDateTime time = ZonedDateTime.parse(tym, Parser);
System.out.println(time);		
		
		
ZonedDateTime dt2 = ZonedDateTime.parse("2017-May-02 23:35:05", DateTimeFormatter
        .ofPattern("yyyy-MMM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Kolkata")));
  System.out.println("--> " +dt2);
  ZonedDateTime zone = ZonedDateTime.now();
  System.out.println("--> " + test.formateDate(dt2));
  
  
  System.out.println(" --- > " + zone);
  zone.plusDays(45);
  
  System.out.println("45+  --- > " + ZonedDateTime.now().plusDays(Integer.MAX_VALUE));
 
  System.out.println("^^^^^^^" + test.formateDate(zone.plusDays(1).withHour(18).withMinute(0)));

  Integer a[] = {1,2,3,4};
  Number b[] = a;
  b[0] = 3.222;
  
  System.out.println(b[0]);
  
  
  
  
	}

	
	
}

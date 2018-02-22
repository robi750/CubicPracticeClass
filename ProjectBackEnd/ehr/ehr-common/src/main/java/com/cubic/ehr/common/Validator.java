package com.cubic.ehr.common;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
	
	private final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	public boolean nameValidator(final String names ) {
		if((names.matches("[a-zA-Z]+")) && (2<=names.length()&&names.length()<=20 )){
			   return true;
		}else
			 return false;
	}
	
	public boolean numberValidator(final Long numbers) {
		String number = Long.toString(numbers);
		
		if (number.length()==11 && (number.substring(0,1).equals("1"))) {
			String num = number.substring(1, number.length());
			return(num.matches("\\d{10}"));
		}else if(number.length() ==10) {
			return(number.matches("\\d{10}"));
		}else
			return false;
	}
	
	public boolean emailValidator(final String emailId) {
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}
	
	public boolean deaNumberValidator(final String deaNumber) {
		if(deaNumber != null && (deaNumber.matches("[a-zA-Z]+[a-zA-Z]+\\d{7}"))) {
			return true;
		}else 
			return false;
	}
	public boolean dobValidation (final Date dob,int min,int max) {
		Date current = new Date();
		LocalDate localDate = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ageDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return((localDate.getYear()-ageDate.getYear()) >= min && (localDate.getYear()-ageDate.getYear())<=max);
		//valid age start from 20 till 60
	}
/*	public boolean dobValidation (final String dob)throws ParseException{
		Date currentDate = new Date();
		int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(currentDate));
		int dobYear;
		if(dob !=null) {
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dob);
			 dobYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
			if(20<(currentYear - dobYear) && (currentYear - dobYear)<60) {
				return true;
			}				
		}
		return false;
	}
*/
}
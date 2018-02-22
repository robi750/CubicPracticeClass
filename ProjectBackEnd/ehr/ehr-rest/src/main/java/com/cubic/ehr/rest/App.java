package com.cubic.ehr.rest;

public class App {

	public static void main(String[] args) {
	/*	//passing date as Date and min max int 
		Date current = new Date();
		LocalDate localDate = current.toInstant().atZone(ZoneId.systemDefault().toLocalDate());
		LocalDate ageDate = date.toinstant()
				return (!(localDate.getYear()-ageDate.getYear()) < min || (localDate.getYear()-ageDate.getYear()))
			
			//dea number validation first 2 dizit alphabet and 7 number
			String deaNumber ="HOO998887";
			if(deaNumber != null && (deaNumber.matches("[a-zA-Z]+[a-zA-Z]+\\d{7}"))) {
				System.out.println("valid: "+deaNumber);
				}else 
					System.out.println("Not valid :"+ deaNumber);
			
		*/	
	/*		// phone number start with 1 total 11 digit validation
			String number = "123467676";
			if (number.length()==11 && (number.substring(0,1).equals("1"))) {
				String num = number.substring(1, number.length());
				System.out.println((num.matches("\\d{10}"))+number);
			}else if(number.length() ==10) {
				System.out.println((number.matches("\\d{10}"))+number);
			}else
				System.out.println("invalid number"+number);
			*/
			
	/*		// name all alphabet min 2 max 20 validation
			String names = "qqqwwqeeeuuurrriiitt";
			if((names.matches("[a-zA-Z]+")) && (2<=names.length()&&names.length()<=20 )){
				System.out.println("ALL alphabet: " +names);
			}else
				System.out.println("NOT alphabet: " + names);
			*/
	/*		
			//email validation
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher("Rdfsdf.3456_-@cubic.com");
			System.out.println( matcher.matches());
		*/
		}
}
package com.cubic.ehr.prescriber.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cubic.ehr.common.Validator;
import com.cubic.ehr.common.exception.InvalidDataException;
import com.cubic.ehr.prescriber.vo.PrescriberVO;

@Component
public class PrescriberValidator extends Validator {
	
	public void prescriberValidator(PrescriberVO prescriber){
		if(prescriber == null) {
			throw new InvalidDataException("!!! Prescriber cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getFirstName())) {
			throw new InvalidDataException("!!! First Name cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getLastName())) {
			throw new InvalidDataException("!!! Last Name cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getPhoneNumber())) {
			throw new InvalidDataException("!!! Phone NUmber cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getDeaNumber())) {
			throw new InvalidDataException("!!! DEA Number cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getSpecialization()) ) {
			throw new InvalidDataException("!!! Specialization cannot be null !!!");
		}else if(StringUtils.isEmpty(prescriber.getGender())) {
			throw new InvalidDataException("!!! Gender cannot be null !!!");
		}
		
		if(nameValidator(prescriber.getFirstName())==false){
			throw new InvalidDataException("Invalid First Name!!");
		}
			
		if(nameValidator(prescriber.getLastName())==false){
			throw new InvalidDataException("Invalid Last Name!!");
		}
		
		if(numberValidator(prescriber.getPhoneNumber())==false){
			throw new InvalidDataException("Invalid PhoneNumber!!");
		}
		
		if(!StringUtils.isEmpty(prescriber.getFaxNumber()) && numberValidator(prescriber.getFaxNumber())==false){
			throw new InvalidDataException("Invalid Fax Number!!");
		}
		
		if(!StringUtils.isEmpty(prescriber.getEmail()) && emailValidator(prescriber.getEmail())==false){
			throw new InvalidDataException("Invalid Email!!"); 
		}
		
		if(deaNumberValidator(prescriber.getDeaNumber())==false){
			throw new InvalidDataException("Invalid DEA Number!!"); 
		}
		
		if(!StringUtils.isEmpty(prescriber.getDob()) && dobValidation(prescriber.getDob(),2,60)==false){
			throw new InvalidDataException("Invalid Date of Birth, valid age start from 20 till 60 !!"); 
		}
	}
	
}

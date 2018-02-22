package com.cubic.ehr.prescriber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.ehr.dao.entity.PrescriberEntity;
import com.cubic.ehr.prescriber.vo.PrescriberVO;

@Component
public class PrescriberMapper {

	public PrescriberEntity mapToPrescriberEntity(final PrescriberVO data) {
		return mapToPrescriberEntity(new PrescriberEntity(), data);
	}

	public PrescriberEntity mapToPrescriberEntity(final PrescriberEntity entity, final PrescriberVO data) {
		entity.setFirstName(data.getFirstName());
		entity.setLastName(data.getLastName());
		entity.setPhoneNumber(data.getPhoneNumber());
		entity.setFaxNumber(data.getFaxNumber());
		entity.setEmail(data.getEmail());
		entity.setDeaNumber(data.getDeaNumber());
		entity.setSpecialization(data.getSpecialization());
		entity.setCreatedDate(data.getCreatedDate());
		entity.setModifiedDate(data.getModifiedDate());
		entity.setStatus(data.getStatus());
		entity.setDescription(data.getDescription());
/*
		String date1 = data.getDob();
		Date date = null;
		if(date1 !=null) {
			try {
				date = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		entity.setDob(date);
		*/

		entity.setDob(data.getDob());
		entity.setGender(data.getGender());
		return entity;
	}

	public PrescriberVO mapToPrescriberVO(final PrescriberEntity entity) {
		final PrescriberVO result = new PrescriberVO();
		result.setId(entity.getId());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setPhoneNumber(entity.getPhoneNumber());
		result.setFaxNumber(entity.getFaxNumber());
		result.setEmail(entity.getEmail());
		result.setDeaNumber(entity.getDeaNumber());
		result.setSpecialization(entity.getSpecialization());
		result.setCreatedDate(entity.getCreatedDate());
		result.setModifiedDate(entity.getModifiedDate());
		result.setStatus(entity.getStatus());
		result.setDescription(entity.getDescription());
/*
		Date date1 = entity.getDob();
		String date;
		if(date1 != null ) {
			date = new SimpleDateFormat("MM/dd/yyyy").format(date1);
		}else {
			date =null;
		}
		result.setDob(date);
		
*/		result.setDob(entity.getDob());
		result.setGender(entity.getGender());
		return result;
	}

	public List<PrescriberVO> mapToPrescriberVOList(final List<PrescriberEntity> entityList) {
		List<PrescriberVO> result = new ArrayList<PrescriberVO>();

		for (PrescriberEntity entity : entityList) {
			result.add(mapToPrescriberVO(entity));
		}
		return result;
	}
}

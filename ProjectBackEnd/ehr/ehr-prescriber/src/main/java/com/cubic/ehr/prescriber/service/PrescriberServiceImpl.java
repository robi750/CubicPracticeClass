package com.cubic.ehr.prescriber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.ehr.common.Status;
import com.cubic.ehr.common.exception.InvalidDataException;
import com.cubic.ehr.dao.entity.PrescriberEntity;
import com.cubic.ehr.dao.repo.PrescriberRepo;
import com.cubic.ehr.prescriber.exception.PrescriberNotfoundException;
import com.cubic.ehr.prescriber.validator.PrescriberValidator;
import com.cubic.ehr.prescriber.vo.PrescriberVO;

@Service
@Transactional
public class PrescriberServiceImpl implements PrescriberService {

	@Autowired
	private PrescriberRepo repo;

	@Autowired
	private PrescriberMapper mapper;
	
	@Autowired
	private PrescriberValidator pv;

	@Override
	public PrescriberVO createPrescriber(PrescriberVO prescriber) {
		pv.prescriberValidator(prescriber);
		
		final PrescriberEntity entity = mapper.mapToPrescriberEntity(prescriber);
		repo.save(entity);
		prescriber.setId(entity.getId());
		return prescriber;
	}

	@Override
	public PrescriberVO modifyPrescriber(PrescriberVO prescriber) {
		if(StringUtils.isEmpty(prescriber.getId())){
			throw new InvalidDataException("ID cannot be null to Modify Prescriber");
		}
		pv.prescriberValidator(prescriber);
		PrescriberEntity entity = repo.findOne(prescriber.getId());
		if (StringUtils.isEmpty(entity)) {
			throw new PrescriberNotfoundException("Prescriber was not found in the System.");
		}
		entity = mapper.mapToPrescriberEntity(entity, prescriber);
		repo.save(entity);

		final PrescriberVO prescriberForReturn = mapper.mapToPrescriberVO(entity);
		return prescriberForReturn;

	}

	@Override
	public PrescriberVO findPrescriber(final Long prescriberId) {

		if (StringUtils.isEmpty(prescriberId)) {
			throw new InvalidDataException("Id is required to Find Prescriber.");
		}
		final PrescriberEntity entity = repo.findOne(prescriberId);
		final PrescriberVO prescriberForReturn = mapper.mapToPrescriberVO(entity);
		return prescriberForReturn;
	}

	@Override
	public List<PrescriberVO> searchPrescriber(final String name, final String deaNumber) {
		
		// .trim() will remove spaces and just take string value between %%
		final String aName = (name == null) ? "%" : name.trim() + "%";
		final String dNumber = (deaNumber == null) ? "%" : deaNumber.trim() + "%";

		final List<PrescriberEntity> entities = repo.search(aName, dNumber);
		return mapper.mapToPrescriberVOList(entities);
	}
	
	@Override
	public void modifyStatus(final Status status, final Long id) {
		if(StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Id is required to Find Prescriber.");
		}
		repo.modifyStatus(status, id);
		
/*		PrescriberEntity entity = repo.modifyStatus(status, id);
		return mapper.mapToPrescriberVO(entity);
*/		
	}

	@Override
	public void removePrescriber(Long id) {
		if (StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Id is required to remove Prescriber.");
		}
		repo.delete(id);
	}

}

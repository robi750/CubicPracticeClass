package com.cubic.ehr.prescriber.service;

import java.util.List;

import com.cubic.ehr.common.Status;
import com.cubic.ehr.prescriber.vo.PrescriberVO;

public interface PrescriberService {

	PrescriberVO createPrescriber(final PrescriberVO prescriber);

	PrescriberVO modifyPrescriber(final PrescriberVO prescriber);

	PrescriberVO findPrescriber(final Long id);

	List<PrescriberVO> searchPrescriber(final String name, final String deaNumber);

	void removePrescriber(final Long id);
	
	void modifyStatus(final Status status, final Long id);
//	PrescriberVO modifyStatus(final Status status, final Long id);


}

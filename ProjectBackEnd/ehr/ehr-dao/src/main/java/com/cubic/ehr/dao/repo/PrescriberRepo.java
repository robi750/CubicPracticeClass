package com.cubic.ehr.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cubic.ehr.common.Status;
import com.cubic.ehr.dao.entity.PrescriberEntity;

public interface PrescriberRepo extends CrudRepository<PrescriberEntity, Long>{

	@Query("select c from PrescriberEntity c where (UPPER(c.firstName) like UPPER(?1) OR UPPER(c.lastName) like UPPER(?1)) AND UPPER(c.deaNumber) like UPPER(?2)")
	List<PrescriberEntity> search(final String name, final String deaNumber);
	
	@Modifying
    @Query("update PrescriberEntity p set p.status=?1 where id = ?2")
    void modifyStatus(final Status status, final Long id);    

   // PrescriberEntity modifyStatus(final Status status, final Long id);    
	@Query("select count(*) from PrescriberEntity c where (UPPER(c.deaNumber) like UPPER(?1))")
	int findDeaNumbers(final String deaNumber);
}


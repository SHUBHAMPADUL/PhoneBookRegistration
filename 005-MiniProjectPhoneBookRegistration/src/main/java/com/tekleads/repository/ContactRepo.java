package com.tekleads.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekleads.entity.ContactDtlsEntity;

public interface ContactRepo extends JpaRepository<ContactDtlsEntity, Serializable> {
	@Modifying
	@Query("update ContactDtlsEntity set activeSw='N' where contactId=:id ")
	public void deleteContact(Integer id);

	public List<ContactDtlsEntity> findByActiveSw(String activeSw);

}

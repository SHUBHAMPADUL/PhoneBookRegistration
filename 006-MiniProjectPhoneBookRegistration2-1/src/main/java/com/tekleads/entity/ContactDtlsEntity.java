package com.tekleads.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_NUM")
	private Long contactNum;

	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;

	@Column(name = "ACTIVE_SW" ,columnDefinition = "varchar2(4) default 'y' ")
	private String activeSw;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdTime;

	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedTime;

}

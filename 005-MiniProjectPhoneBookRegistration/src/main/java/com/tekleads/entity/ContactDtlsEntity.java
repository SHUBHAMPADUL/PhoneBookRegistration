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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Contact_persion")
public class ContactDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name = "C_Id")
	private Integer contactId;

	@Column(name = "C_Name")
	private String contactName;

	@Column(name = "C_Num")
	private Long contactNum;

	@Column(name = "C_Email")
	private String contactEmail;

	@Column(name = "Active_Sw", columnDefinition = "varchar2(4) default 'y' ")
	private String activeSw;

	@Column(name = "CREATED_TIME")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdTime;

	@Column(name = "UPDATE_TIME")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedTime;

}

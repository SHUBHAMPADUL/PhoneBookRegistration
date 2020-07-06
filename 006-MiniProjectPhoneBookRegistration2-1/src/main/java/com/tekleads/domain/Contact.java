package com.tekleads.domain;

import lombok.Data;

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactEmail;
	private String activeSw;

}

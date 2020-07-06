package com.tekleads.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactEmail;
	private String activeSw;
	

}

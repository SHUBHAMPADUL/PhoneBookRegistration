package com.tekleads.service;

import javax.persistence.Convert;

import com.tekleads.contact.Contact;

interface ContactService {
	public boolean saveContact(Contact contact);

	public Iterable<Contact> retriveAllActiveContacts();

	public Contact findContactById(Integer id);

	public boolean updateContactById(Integer id);

	public boolean deleteContactById(Integer id);

}

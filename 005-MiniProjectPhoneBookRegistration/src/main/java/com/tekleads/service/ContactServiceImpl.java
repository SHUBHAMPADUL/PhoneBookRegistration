
package com.tekleads.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.contact.Contact;
import com.tekleads.entity.ContactDtlsEntity;
import com.tekleads.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepo contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("y");
		ContactDtlsEntity contactEntity = contactRepo.save(entity);

		return contactEntity.getContactId() != null;
	}

	@Override
	public Iterable<Contact> retriveAllActiveContacts() {
		List<Contact> contact = new ArrayList<Contact>();
		Iterable<ContactDtlsEntity> contactDtlEntity = contactRepo.findByActiveSw("y");
		contactDtlEntity.forEach(Entity -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(Entity, c);
			contact.add(c);
		});
		return contact;
	}

	@Override
	public Contact findContactById(Integer id) {
		Optional<ContactDtlsEntity> contactdtlEntity = contactRepo.findById(id);
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactdtlEntity, contact);
		return contact;
	}

	@Override
	public boolean updateContactById(Integer id) {
		Contact contact = findContactById(id);
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity save = contactRepo.save(entity);
		return save != null;
	}

	@Override
	@Transactional
	public boolean deleteContactById(Integer id) {
		contactRepo.deleteContact(id);
		return true;
	}

}

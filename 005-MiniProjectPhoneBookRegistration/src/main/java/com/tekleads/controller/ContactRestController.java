
package com.tekleads.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekleads.contact.Contact;
import com.tekleads.service.ContactServiceImpl;

import lombok.Getter;

@Controller
public class ContactRestController {
	@Autowired
	private ContactServiceImpl service;

	@GetMapping(value = "/showForm")
	public String showForm(Model model) {
		Contact contact = new Contact();

		model.addAttribute("contact", contact);

		return "contact_form";

	}

	@PostMapping("/showForm")
	public String showcontact(Model model, @ModelAttribute("contact") Contact contact) {
		// use service
		boolean saveContact = service.saveContact(contact);
		if (saveContact) {
			model.addAttribute("Saved", "saved contact");
		} else {
			model.addAttribute("Saved", "contact Is Not saved");
		}
		return "contact_form";

	}
    
	@RequestMapping("/showAllContact")
	public String showAllContact(Model model) {
		Iterable<Contact> contacts = service.retriveAllActiveContacts();
		model.addAttribute("contacts", contacts);
		return "all_contact";

	}

	@GetMapping("/updateContact")
	public String updateContact(Model model, HttpServletRequest req) {
		Integer id = Integer.parseInt(req.getParameter("contactId"));
		Contact contact = service.findContactById(id);
		model.addAttribute("contact", contact);

		return "contact_form";
	}

	@PostMapping("/updateContact")
	public String updateContact(Model model, @ModelAttribute("contact") Contact contact) {
		boolean saveContact = service.saveContact(contact);
		model.addAttribute("save", saveContact);
		return "contact_form";
	}

	@RequestMapping("/deleteContact")
	public String deleteContact(Model model, @ModelAttribute("contact") Contact contact, HttpServletRequest req) {
		Integer id = Integer.parseInt(req.getParameter("contactId"));
		boolean isDelete = service.deleteContactById(id);
		if (isDelete) {
			model.addAttribute("delete", "contact deleted");
		} else {
			model.addAttribute("delete", "contact NOt Deleted");
		}
		return "all_contact";

	}

}

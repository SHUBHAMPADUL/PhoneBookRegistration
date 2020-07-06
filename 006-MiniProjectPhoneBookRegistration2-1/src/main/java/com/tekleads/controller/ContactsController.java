package com.tekleads.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekleads.domain.Contact;
import com.tekleads.service.ContactService;

@Controller
public class ContactsController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/loadForm")
	public String init(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contact";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, Model model) {
		boolean isSaved = contactService.saveContact(c);
		if (isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		} else {
			model.addAttribute("errMsg", "Failed to save");
		}
		return "contact";
	}

	@RequestMapping("/viewAllContacts")
	public String handleViewAllContactsHyperLink(Model model) {
		List<Contact> clist = contactService.retrieveAllActiveContacts();
		model.addAttribute("contacts", clist);
		return "viewContacts";
	}

	@RequestMapping("/editContact")
	public String handleEditLink(HttpServletRequest req, Model model) {
		String cid = req.getParameter("cid");
		Contact c = contactService.findContactById(Integer.parseInt(cid));
		model.addAttribute("contact", c);
		return "contact";
	}

}

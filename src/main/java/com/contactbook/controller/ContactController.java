package com.contactbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactbook.model.Contact;
import com.contactbook.repository.ContactRepository;

@RestController
@RequestMapping(value="/api")
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	
	@PostMapping("/contact")
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@GetMapping("/contacts")
	public List<Contact> listAllContacts() {
		return contactRepository.findAll();
	}
	
	@GetMapping("/contact/{id}")
	public Contact getContactById(@PathVariable(value="id") long id) {
		return contactRepository.findById(id);
	}
	
	@GetMapping("/contactEmail/{email}")
	public List<Contact> getContactsByEmail(@PathVariable(value="email") String email){
		return contactRepository.findByEmail(email);
	}	
	
	@DeleteMapping("/contact/{id}")
	public void deleteContact(@PathVariable(value="id") long id) {
		 contactRepository.deleteById(id);
	}
	

	
	
	
	
	
}

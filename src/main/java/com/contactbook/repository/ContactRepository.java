package com.contactbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactbook.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	Contact findById(long id);
	List<Contact> findByEmail(String email);
}

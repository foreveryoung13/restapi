package com.nana.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.restapi.demo.dao.ContactDAO;
import com.nana.restapi.demo.domain.Contact;

/**
 *
 * @author nana
 * 
 */

@Service
public class ContactService {

	@Autowired
	private ContactDAO dao;

	public List<Contact> getContactList() {
		return dao.getContactList();
	}

}

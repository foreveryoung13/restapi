package com.nana.restapi.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nana.restapi.demo.dao.mapper.ContactMapper;
import com.nana.restapi.demo.domain.Contact;

/**
 *
 * @author nana
 * 
 */

@Repository
public class ContactDAO {

	@Autowired
	private ContactMapper mapper;

	public List<Contact> getContactList() {
		return mapper.getContactList();
	}

}

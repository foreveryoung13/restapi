package com.nana.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.restapi.demo.dao.TestDAO;
import com.nana.restapi.demo.domain.Contact;

/**
*
* @author nana
* 
*/

@Service
public class TestService {

	@Autowired
	private TestDAO dao;

	public List<Contact> getContactList() {
		return dao.getContactList();
	}
	
	public Integer getValue() {
		return dao.getValue();
	}

}

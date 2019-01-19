package com.nana.restapi.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nana.restapi.demo.domain.Contact;

/**
*
* @author nana
* 
*/

@Repository
public class TestDAO {

	public List<Contact> getContactList() {
		Contact c1 = new Contact();
		c1.setFirstName("Nana");
		c1.setLastName("Febriana");

		Contact c2 = new Contact();
		c2.setFirstName("Sandi");
		c2.setLastName("Oktavian");

		List<Contact> list = new ArrayList<Contact>();
		list.add(c1);
		list.add(c2);

		return list;

	}

	public Integer getValue() {
		return 7;
	}

}

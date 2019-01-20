package com.nana.restapi.demo.dao;

import org.springframework.stereotype.Repository;

import com.nana.restapi.demo.domain.LookupDetails;

/**
 *
 * @author nana
 * 
 */

@Repository
public class LookupDetailsDAO {

	public LookupDetails getLookupDetails() {
		LookupDetails detail = new LookupDetails();
		detail.setUsername("username");
		detail.setPassword("password");

		return detail;
	}

}

package com.nana.restapi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.restapi.demo.dao.LookupDetailsDAO;
import com.nana.restapi.demo.domain.LookupDetails;

@Service
public class LookupDetailsService {

	@Autowired
	private LookupDetailsDAO dao;

	LookupDetails getLookupDetails() {
		return dao.getLookupDetails();
	}
}

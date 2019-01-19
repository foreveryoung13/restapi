package com.nana.restapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nana.restapi.demo.domain.Contact;
import com.nana.restapi.demo.dto.APIResult;
import com.nana.restapi.demo.service.ContactService;
import com.nana.restapi.demo.util.ErrorCode;

/**
 *
 * @author nana
 * 
 */

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public APIResult contactList() {
		
		APIResult apiResult = new APIResult();

		try {
			List<Contact> list = contactService.getContactList();
			apiResult.setResult(list);

		} catch (Exception e) {
			ErrorCode errCode = ErrorCode.COMMON_ERROR;
			apiResult = new APIResult(errCode);
		}

		return apiResult;
	}
}

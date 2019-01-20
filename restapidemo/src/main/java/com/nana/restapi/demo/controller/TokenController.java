package com.nana.restapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nana.restapi.demo.dto.APIResult;
import com.nana.restapi.demo.dto.TokenRequest;
import com.nana.restapi.demo.dto.TokenResult;
import com.nana.restapi.demo.service.TokenService;
import com.nana.restapi.demo.util.ErrorCode;

/**
 *
 * @author nana
 */
@RestController
public class TokenController {

	@Autowired
	protected TokenService service;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public APIResult getToken(@RequestBody TokenRequest request) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("--------------------REQUEST TOKEN------------------------------");

		APIResult apiResult = new APIResult();

		try {
			String token = service.generate(request.getUsername(), request.getPassword());
			System.out.println(token);

			if (token != null) {
				apiResult.setResult(new TokenResult(token));
			} else {
				apiResult.setError(ErrorCode.AUTH_TOKEN_ERROR);
			}
		} catch (Exception e) {
			ErrorCode errCode = ErrorCode.COMMON_ERROR;
			apiResult = new APIResult(errCode);
			apiResult.setResult(e.toString());
		}

		return apiResult;
	}
}

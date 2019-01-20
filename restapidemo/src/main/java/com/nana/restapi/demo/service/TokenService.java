package com.nana.restapi.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.restapi.demo.domain.LookupDetails;

/**
 *
 * @author nana
 */

@Service
public class TokenService {

	protected Logger logger = Logger.getLogger(this.getClass());
	protected Key key = Keys.secretKeyFor(SignatureAlgorithm.HS384);

	@Autowired
	protected LookupDetailsService lookupService;

	public String generate(String userId, String password) throws Exception {

		String result = null;

		LookupDetails lookup = lookupService.getLookupDetails();

		if (lookup != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.HOUR, 1);

			result = Jwts.builder().setSubject(userId).setIssuedAt(new Date()).setExpiration(cal.getTime())
					.signWith(key).compact();
		}

		return result;
	}

	public boolean validate(String token) throws Exception {
		boolean result = false;

		Claims claim = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		
		result = true;
		return result;
	}
}

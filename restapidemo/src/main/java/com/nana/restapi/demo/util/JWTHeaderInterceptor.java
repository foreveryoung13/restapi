package com.nana.restapi.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nana.restapi.demo.dto.APIResult;
import com.nana.restapi.demo.service.TokenService;

import io.jsonwebtoken.ExpiredJwtException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author nana
 */
public class JWTHeaderInterceptor extends HandlerInterceptorAdapter {

	protected Logger logger = Logger.getLogger(this.getClass());

	protected String[] excludeList = {};
	protected String[] excludePOSTList = {};
	protected String[] excludeGETList = {};

	@Autowired
	protected TokenService tokenService;

	public void setExclude(String exclude) {
		System.out.println("excludeList " + exclude);
		excludeList = exclude.split(",");
		System.out.println();
	}

	public void setExcludePost(String exclude) {
		System.out.println();
		System.out.println("excludePOSTList " + exclude);
		excludePOSTList = exclude.split(",");
		System.out.println();
	}

	public void setExcludeGet(String exclude) {
		System.out.println();
		System.out.println("excludeGETList " + exclude);
		excludeGETList = exclude.split(",");
		System.out.println();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.debug("Accessing : " + request.getPathInfo() + ", auth : " + request.getHeader("Authorization"));
		System.out.println(request.getPathInfo() + ", auth : " + request.getHeader("Authorization"));
		
		
		boolean result = false;

		for (String exclude : excludeList) {
			System.out.println("exclude wkwkw " + exclude);
			if (request.getPathInfo().matches(exclude)) {

				result = true;

				logger.debug("Exluded from JWThandler : " + exclude);
				break;
			}
		}

		if (!result) {

			if ("POST".equals(request.getMethod().toUpperCase())) {

				for (String exclude : excludePOSTList) {

					if (request.getPathInfo().matches(exclude)) {

						result = true;

						logger.debug("Exluded from JWThandler POST : " + exclude);
						break;
					}
				}
			} else if ("GET".equals(request.getMethod().toUpperCase())) {

				for (String exclude : excludeGETList) {

					if (request.getPathInfo().matches(exclude)) {

						result = true;

						logger.debug("Exluded from JWThandler GET : " + exclude);
						break;
					}
				}
			}
		}

		if (!result) {

			String auth = request.getHeader("Authorization");
			ErrorCode errCode = ErrorCode.COMMON_ERROR;

			int code = 1;

			if (auth != null) {

				String token = auth.substring(7);

				try {

					result = tokenService.validate(token);

					if (!result)
						errCode = ErrorCode.AUTH_TOKEN_ERROR;
					else
						logger.debug("Auth valid");
				} catch (ExpiredJwtException e) {

					errCode = ErrorCode.AUTH_TOKEN_ERROR;
				} catch (Exception e) {

					errCode = ErrorCode.AUTH_TOKEN_ERROR;
				}
			} else
				errCode = ErrorCode.AUTH_TOKEN_EMPTY;

			if (!result) {

				APIResult apiResult = new APIResult(errCode);
				ObjectMapper objMapper = new ObjectMapper();

				logger.debug("Auth invalid : " + errCode.getErrorMsg());

				response.setStatus(401);
				response.setContentType("application/json");
				response.getWriter().write(objMapper.writeValueAsString(apiResult));
			}
		}

		return result;
	}
}

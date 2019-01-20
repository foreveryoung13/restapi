package com.nana.restapi.demo.dto;

public class TokenResult {

	private String accessToken;

	public TokenResult(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}

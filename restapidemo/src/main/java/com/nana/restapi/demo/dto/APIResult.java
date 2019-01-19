package com.nana.restapi.demo.dto;

import com.nana.restapi.demo.util.ErrorCode;

/**
*
* @author nana
* 
*/

public class APIResult {

	protected int errorCode = 0;
	protected String errorMsg = "SUCCESS";
	protected Object result = "";

	public APIResult() {
	}

	public APIResult(ErrorCode errCode) {

		errorCode = errCode.getErrorCode();
		errorMsg = errCode.getErrorMsg();
	}

	public APIResult(Object result) {

		errorCode = 0;
		errorMsg = "SUCCESS";
		this.result = result;
	}

	public void setError(ErrorCode errCode) {

		errorCode = errCode.getErrorCode();
		errorMsg = errCode.getErrorMsg();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}

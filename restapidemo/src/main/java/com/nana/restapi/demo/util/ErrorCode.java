package com.nana.restapi.demo.util;

public enum ErrorCode {

	AUTH_TOKEN_EMPTY    (22222, "TOKEN IS EMPTY"),
	AUTH_TOKEN_ERROR    (44444, "AUTHENTICATION ERROR"),
    COMMON_ERROR        (99999, "GENERAL ERROR");
    
    protected int errorCode;
    protected String errorMsg;
    
    ErrorCode(int code, String msg) {
        errorCode = code;
        errorMsg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }    
    
}

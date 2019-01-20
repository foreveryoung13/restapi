package com.nana.restapi.demo.util;

public enum ErrorCode {

    AUTH_TOKEN_ERROR                    (10001, "Token error"),
    AUTH_TOKEN_EMPTY                    (10002, "Token empty"),
    AUTH_TOKEN_EXPIRED                  (10003, "Token expired"),
    AUTH_TOKEN_INVALID                  (10004, "Token invalid"),
    AUTH_FAILED                         (10005, "Authetication failed"),
    COMMON_ERROR        				(99999, "GENERAL ERROR");
    
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

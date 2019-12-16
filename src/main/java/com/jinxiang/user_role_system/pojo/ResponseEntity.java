package com.jinxiang.user_role_system.pojo;

/**
 * 返回值实体类
 */
public class ResponseEntity<T> {

    private int code;

    private Boolean issuccess;

    private String message;

    private T result;

    public ResponseEntity(){}

    public ResponseEntity(int Code, Boolean Issuccess, String message, T result) {
        this.code = Code;
        this.message = message;
        this.issuccess = Issuccess;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Boolean issuccess) {
        this.issuccess = issuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}

package com.business.common.base;

public class ResponseResult {
	private boolean status=true;
    private String message="操作成功";
    private Object data;

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public ResponseResult(String message, Object data) {
        super();
        this.message = message;
        this.data = data;
    }
    public ResponseResult(boolean status) {
        super();
        this.status = status;
    }
    public ResponseResult() {
        super();
    }
}

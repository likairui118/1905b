package com.fh.utils;

public class ResponseData {
    private Integer code;

    private String message;

    private Object data;

    private ResponseData(){

    }

    public ResponseData(Integer code,String message,Object data){
        this.code=code;
        this.data=data;
        this.message=message;
    }

    public static ResponseData success(Object data){
        return  new ResponseData(200,"success",data);
    }

    public static ResponseData error(String message){
        return  new ResponseData(500,message,null);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}

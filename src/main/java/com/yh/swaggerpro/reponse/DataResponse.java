package com.yh.swaggerpro.reponse;


import com.yh.swaggerpro.emun.StatusCode;

import java.io.Serializable;

/**
 * Description:
 *
 * @author:yh
 * @date:2019/6/25 23:04
 */
public class DataResponse<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public DataResponse() {
    }

    public DataResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public DataResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DataResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

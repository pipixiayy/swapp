package com.yh.swaggerpro.emun;

/**
 * Description:
 *
 * @author:yh
 * @date:2019/6/25 23:04
 */
public enum StatusCode {
    Success("0","成功"),
    Fail("-1","失败"),
    InvalidParams("200","无效参数"),
    loginSuccess("0000","登录成功"),
    loginFail("9999","用户不存在"),
    loginFailPassword("8888","用户密码错误"),
    fileLoadSuccess("6666","文件上传成功"),
    fileLoadType("6432","文件上传成功"),
    fileLoadFail("6888","文件上传异常"),
    LoginError("6543","登录异常");

    private String code;
    private String msg;

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}

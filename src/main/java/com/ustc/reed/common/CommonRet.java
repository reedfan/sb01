package com.ustc.reed.common;

/**
 * Created by liqingwen@qiyi.com on 2016-09-16.
 * 返回到前端的通用封装类
 */
public class CommonRet {
    private String code;
    private String msg;
    public final static String SUCCESS = "A00000";
    public final static String SUCCESS_MSG = "success";
    public final static String ERROR = "A00001";
    public final static String ERROR_MSG = "general internal error";

    public CommonRet() {
        this(SUCCESS, SUCCESS_MSG);
    }

    public CommonRet(String code, String msg) {
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

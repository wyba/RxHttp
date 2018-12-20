package com.wyb.rxhttp.response;

public class CommonResponse {

    private String msg;

    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}

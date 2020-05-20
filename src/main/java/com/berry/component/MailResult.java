package com.berry.component;

public class MailResult {
    private String rspCode;
    private String rspMsg;

    public MailResult() {
        this.rspCode = "00";
        this.rspMsg = "发送成功";
    }

    public String getRspCode() {
        return rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }
}

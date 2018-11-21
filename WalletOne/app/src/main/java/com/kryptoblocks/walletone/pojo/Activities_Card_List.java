package com.kryptoblocks.walletone.pojo;

/**
 * Created by Admin on 16-10-2017.
 */

public class Activities_Card_List {
    private String sent_to;
    private String date;
    private String amt;
    private String time;
    private String status;



    public Activities_Card_List() {
    }

    public Activities_Card_List(String sent_to,String date, String amt, String time, String status) {
        this.sent_to = sent_to;
        this.date = date;
        this.amt = amt;
        this.time = time;
        this.status = status;
    }

    public String getSent_to() {
        return sent_to;
    }
    public void setSent_to(String sent_to) {
        this.sent_to = sent_to;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getAmt() {
        return amt;
    }
    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String  getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String  getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

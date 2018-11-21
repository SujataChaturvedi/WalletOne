package com.kryptoblocks.walletone.pojo;

/**
 * Created by Admin on 23-10-2017.
 */

public class Recent_activities {
    private String sent_to;
    private String field;
    private String amt;



    public Recent_activities() {
    }

    public Recent_activities(String sent_to,String field, String amt) {
        this.sent_to = sent_to;
        this.field = field;
        this.amt = amt;

    }

    public String getSent_to() {
        return sent_to;
    }
    public void setSent_to(String sent_to) {
        this.sent_to = sent_to;
    }

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }

    public String getAmt() {
        return amt;
    }
    public void setAmt(String amt) {
        this.amt = amt;
    }


}



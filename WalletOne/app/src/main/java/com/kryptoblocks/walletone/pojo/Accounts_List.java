package com.kryptoblocks.walletone.pojo;

/**
 * Created by Admin on 29-11-2017.
 */

public class Accounts_List {
    private String label;
    private float balance;
    private String last_activity;

    public Accounts_List() {
    }

    public Accounts_List(String label,float balance, String last_activity) {
        this.label = label;
        this.balance = balance;
        this.last_activity = last_activity;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String sent_to) {
        this.label = sent_to;
    }

    public Float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getLast_activity() {
        return last_activity;
    }
    public void setLast_activity(String last_activity) {
        this.last_activity = last_activity;
    }

}

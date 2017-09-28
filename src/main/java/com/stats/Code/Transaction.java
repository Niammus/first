package com.stats.Code;

public class Transaction {

    private double amount;
    private long timeStamp;

    public Transaction() {
        super();
    }

    public Transaction (double amount, long timeStamp){
        this.amount=amount;
        this.timeStamp=timeStamp;
    }

    public double getAmount (){
        return amount;
    }

    public double getTimeStamp (){
        return timeStamp;
    }

}

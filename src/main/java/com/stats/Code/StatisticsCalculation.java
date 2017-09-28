package com.stats.Code;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class StatisticsCalculation {
    private double Sum,Avg,Max,Min;
    private long Count;
    private long time;
    private List<Transaction> array;
    private Double[] amounts;
    private int x;

    public StatisticsCalculation() {
        super();
    }


    StatisticsCalculation(List<Transaction> array, long time) {
        this.time = time;
        this.array = array;
        this.amounts = array.stream ().filter (Objects::nonNull).filter (x -> (time - x.getTimeStamp ()) <= 60000).map (Transaction::getAmount).toArray (Double[]::new);
    }



    double getSum(){
        Sum = Arrays.stream (amounts).reduce (0.0, (a, e) -> a + e);
        if (Double.isNaN(Sum))
            return 0.0;
        else return Sum;
    }

    double getAvg(){
        Avg = Sum / amounts.length;
        if (Double.isNaN(Avg))
            return 0.0;
        else return Avg;
    }

    double getMax(){
        Max = Arrays.stream (amounts).max (Double::compare).orElse (0.0);
        if (Double.isNaN(Max))
            return 0.0;
        else return Max;
    }

    double getMin(){
        Min = Arrays.stream (amounts).min (Double::compare).orElse(0.0);
        if (Double.isNaN(Min))
            return 0.0;
        else return Min;
    }

    long getCount(){
        Count = amounts.length;
        return Count;

    }







}

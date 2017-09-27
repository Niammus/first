package com.mustafa.code;

import java.util.List;
import java.util.stream;
import java.util.stream.Collectors;

public class StatisticsObject {
    private long Sum,Avg,Max,Min,Count;
    private Transaction[] array = new Transaction[6000] ;

    public StatisticsObject (Transaction array[]){
        this.array=array;
    }

    public long getSum (){
        List<Integer> names =
                array.stream ()
                        .map(Transaction::getAmount)
                        .collect(Collectors.toList());
        return Sum;
    }

    public long getAvg (){
        return Avg;
    }

    public long getMax (){
        return Max;
    }

    public long getMin(){
        return Min;
    }

    public long getCount (){
        return Count;
    }

}

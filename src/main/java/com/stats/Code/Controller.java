package com.stats.Code;


import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;


@RestController
public class Controller {

    private Transaction[] transactions = new Transaction[60000];
    private int p=0;

    @RequestMapping(value = ("/statistics"), method = RequestMethod.POST)
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        transactions[p % transactions.length] = transaction;
        if (System.currentTimeMillis()-transactions[p%transactions.length].getTimeStamp() <= 60000){
            p++;
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            System.out.println (p);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }



    }


    @RequestMapping(value = ("/statistics"), method = RequestMethod.GET)
    public ResponseEntity<String> getStatistics() {

        StatisticsCalculation stat = new StatisticsCalculation (new ArrayList<Transaction>(Arrays.asList (transactions)),System.currentTimeMillis());
        StatisticsData data = new StatisticsData (stat.getSum (),stat.getAvg (),stat.getMax (),stat.getMin (),stat.getCount ());
        Gson gson = new Gson();
        String jsonInString = gson.toJson(data);
        return new ResponseEntity<>(jsonInString,HttpStatus.OK);
    }
}

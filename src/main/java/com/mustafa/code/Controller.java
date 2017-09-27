package com.mustafa.code;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller {

    Transaction[] transactions = new Transaction[6000];

    @RequestMapping(value = ("/statistics"), method = RequestMethod.POST)
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {

        transactions[0]=transaction;
        if (System.currentTimeMillis()-transactions[0].getTimeStamp() <= 60)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @RequestMapping(value = ("/statistics"), method = RequestMethod.GET)
    public ResponseEntity<String> getStatistics() {



        return new ResponseEntity<>(HttpStatus.OK);
    }
}

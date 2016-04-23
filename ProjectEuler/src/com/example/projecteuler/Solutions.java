package com.example.projecteuler;

/**
 * Created by PG212 on 22/04/2016.
 */
public class Solutions {

    public Solutions() {
    }

    public int S0001() {

        int sum = 0;

        for (int i = 0; i < 1000; i++){
            if (i%3 == 0 || i%5 == 0){
                sum = sum + i;
            }
        }

        return sum;
    }

    // This can be done better adding to list arrays perhaps?
    public int S0002() {

        int sum = 0;
        int seq = 0;
        int curr = 1;
        int prev = 0;
        int lim = 4000000;

        while (sum < lim){

            if (curr%2 == 0) sum = sum + curr;

            seq = prev + curr;
            prev = curr;
            curr = seq;
        }

        return sum;
    }

}

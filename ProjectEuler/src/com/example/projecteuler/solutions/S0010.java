package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

import java.util.HashMap;
import java.util.List;

public class S0010 implements Solution {
    @Override
    public String getAnswer(){
        return Long.toString(originalSolution());
    }

    private long originalSolution() {

        int target = 2000000;
        long sum = 0;

        List<Integer> primes = PrimeHelper.getInstance().findPrimesUnder(target);

        for (int prime : primes) {
            sum += prime;
        }
        return sum;
    }
}

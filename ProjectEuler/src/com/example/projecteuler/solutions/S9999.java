package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

import java.util.List;

public class S9999 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {
        List<Integer> primes = PrimeHelper.getInstance().findPrimesUnder(10000);
        return primes.get(primes.size()-1);
    }

}

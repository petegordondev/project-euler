package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.math.BigInteger;

public class S0025 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int target = 1000;
    private int size;
    private int n = 3;

    private int originalSolution() {

        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("1");
        BigInteger curr;

        while (size < target){
            curr = n2.add(n1);
            size = curr.toString().length();
            if (size >=target) break;
            n1 = n2;
            n2 = curr;
            n++;
        }

        return n;
    }
}

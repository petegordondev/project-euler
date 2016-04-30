package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;


public class S0006 implements Solution {
    @Override
    public int getAnswer() {
        return originalSolutions();
    }

    private int originalSolutions() {
        int n = 100;
        long sumOfSquared = 0;
        long squaredOfSum = 0;

        // Sum of the squared.
        for (int i = 1; i <= n; i++){
            sumOfSquared += Math.pow(i, 2);
        }
        // Squared of sum.
        for (int i = 1; i <= n; i++){
            squaredOfSum += i;
        }

        squaredOfSum = (long) Math.pow(squaredOfSum, 2);

        return (int) (squaredOfSum - sumOfSquared);
    }
}

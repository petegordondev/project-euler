package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0014 implements Solution {

    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {
        int result = 0;
        int target = 1000000;
        int iterationsUpper = 0;

        for (int i = target -1; i > 0; i--){
            int iterations = 0;
            long n = i;
            while (n != 1){
                iterations++;
                if (n % 2 == 0){
                    n /= 2;
                } else {
                    n *= 3;
                    n += 1;
                }
            }
            if (iterations > iterationsUpper){
                iterationsUpper = iterations;
                result = i;
            }
        }

        return result;
    }
}

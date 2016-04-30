package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0001 implements Solution {
    @Override
    public int getAnswer() {
        return originalSolution();
    }

    private int originalSolution() {

        int sum = 0;

        for (int i = 0; i < 1000; i++){
            if (i%3 == 0 || i%5 == 0){
                sum = sum + i;
            }
        }

        return sum;
    }

    private int improvedSolution() {
        return 0;
    }
}

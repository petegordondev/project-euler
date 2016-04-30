package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0005 implements Solution {
    @Override
    public int getAnswer() {
        return originalSolution();
    }

    private int originalSolution() {
        int n = 20;
        int multiple = -1;
        boolean multipleFound = false;
        long fact = 1;

        for (int i = 1; i <= n; i++){
            fact *= i;
        }

        for (int i = 10; i <= fact; i++){
            for (int j = 1; j <= n; j++){
                if (i%j == 0){
                    multipleFound = true;
                } else {
                    multipleFound = false;
                    break;
                }
            }
            if (multipleFound){
                multiple = i;
                break;
            }
        }

        return multiple;
    }
}

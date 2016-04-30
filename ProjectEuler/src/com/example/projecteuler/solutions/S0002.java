package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0002 implements Solution{
    @Override
    public int getAnswer() {
        return originalSolution();
    }

    private int originalSolution(){
        int seq;
        int sum = 0;
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

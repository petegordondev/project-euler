package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.FactorHelper;

public class S0021 implements Solution {

    private int target = 10000;

    @Override
    public String getAnswer()  {
        return Integer.toString(improved_solution());
    }


    private int original_solution() {

        int sum = 0;

        for (int a = 0; a <= target; a++){
            int b = new FactorHelper(a).sum() - a;
            int bSum = new FactorHelper(b).sum() - b;
            if (a == bSum && a!= b){
                sum += b;
            }
        }
        return sum;
    }

    private int improved_solution() {

        int sum = 0;

        for (int a = 0; a <= target; a++){
            int b = new FactorHelper(a).sumProper();
            int bSum = new FactorHelper(b).sumProper();
            if (a == bSum && a!= b){
                sum += b;
            }
        }
        return sum;
    }
}

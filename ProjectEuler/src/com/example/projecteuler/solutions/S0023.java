package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.FactorHelper;

import java.util.ArrayList;
import java.util.List;

public class S0023 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int target = 28123;

    private int original_solution() {
        int sum = 0;

        //Find all perfect numbers up to target.
        List<Integer> lPerfect = new ArrayList<>();

        for (int n = 1; n < target; n++){
            if (n == new FactorHelper(n).sumProper()) lPerfect.add(n);
        }

        //Find all pair sum results (no duplicates.


        //Subtract from traingular sum.


        return sum;
    }
}

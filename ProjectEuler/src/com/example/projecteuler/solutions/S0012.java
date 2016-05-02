package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.FactorHelper;
import com.example.projecteuler.utils.TriangularHelper;

import java.util.List;

public class S0012 implements Solution {
    @Override
    public String getAnswer() {
        return Long.toString(originalSolution());
    }

    private long originalSolution() {

        int target = 500;
        int count = 0;
        int n = 0;

        TriangularHelper th = new TriangularHelper();

        while (count <= target){
            n++;
            count = new FactorHelper(th.get(n)).count();
        }

        return th.get(n);
    }
}

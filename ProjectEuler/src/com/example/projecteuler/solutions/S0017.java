package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.StringHelper;
import com.sun.corba.se.spi.activation.ServerOperations;

public class S0017 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int sum = 0;

    private int originalSolution() {

        int target = 1000;
        for (int i = 1; i <= target; i++){
            String s = new StringHelper().numberAsWords(i);
            s = s.replaceAll("\\s","");
            s = s.replaceAll("-","");
            sum += s.length();
        }

        return sum;
    }

}

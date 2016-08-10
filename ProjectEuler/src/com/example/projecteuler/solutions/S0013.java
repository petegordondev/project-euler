package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.DataFileHelper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class S0013 implements Solution {
    @Override
    public String getAnswer() {
        return originalSolution();
    }

    private String originalSolution() {

        int target = 10;

        DataFileHelper file = new DataFileHelper("D0013");
        List<BigInteger> list = new ArrayList<>();

        for (String s: file.toStringArrayLines()){
            list.add(new BigInteger(s));
        }

        BigInteger sum = new BigInteger("0");
        for (BigInteger bi : list){
            sum = sum.add(bi);
        }

        // Convert sum to string and get first 10 digits.
        String sSum = sum.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target; i++){
            sb.append(sSum.charAt(i));
        }

        return sb.toString();
    }
}

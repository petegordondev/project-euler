package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.sun.org.apache.xml.internal.utils.res.LongArrayWrapper;

import java.math.BigInteger;

public class S0016 implements Solution{
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int sum = 0;
    private int targetExponent = 1000;
    private int targetBase = 2;

    private int originalSolution() {

        BigInteger num = new BigInteger("1");

        // Break exponent down into chunks.

        for (int i = 0; i < targetExponent / 10; i++) {
            long chunk = (long) Math.pow(targetBase, 10);
            num = num.multiply(BigInteger.valueOf(chunk));
        }

        long chunkRem = (long) Math.pow(targetBase, targetExponent % 10);
        num = num.multiply(BigInteger.valueOf(chunkRem));

        String digits = num.toString();

        for (int i = 0; i < digits.length(); i++) {
            sum += Character.getNumericValue(digits.charAt(i));
        }

        return sum;
    }
}

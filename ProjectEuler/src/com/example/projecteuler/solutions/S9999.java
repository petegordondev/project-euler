package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

import java.util.List;
import java.util.Scanner;

public class S9999 implements Solution {
    @Override
    public String getAnswer() {
        return Boolean.toString(originalSolution());
    }

    private boolean originalSolution() {

        Scanner sc = new Scanner(System.in);

        int i = 1000000;
        long l = (long) i;

        return PrimeHelper.getInstance().isPrime(i);
    }

}

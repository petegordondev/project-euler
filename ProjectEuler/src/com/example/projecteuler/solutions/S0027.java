package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

public class S0027 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int original_solution() {

        int res = 0;

for (int i = 2; i < 100; i++){
    System.out.println(i + "\t" + new PrimeHelper().isPrime(i));
}

        return 0;
    }
}

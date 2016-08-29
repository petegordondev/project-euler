package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class S0029 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int target = 100;
    private Set<BigInteger> set = new TreeSet<>();

    private int original_solution() {

        for (int a = 2; a <= target; a++)
        {
            for (int b = 2; b <= target; b++)
            {
                BigInteger res = BigInteger.valueOf(a).pow(b);
                set.add(res);
            }
        }

        return set.size();
    }
}

package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class S0009 implements Solution {

    private int a;
    private int b;
    private int c;
    private int target = 1000;

    @Override
    public int getAnswer() {
        return originalSolution();
    }

    private int originalSolution() {

        // Generate Pythagorean triples using Euclid's formula.
        // Check each iteration if sum equals target.
        int m;
        int n;
        int k;

        for (k = 1; sum() < target; k++)
        {
            for (n = 1; sum() < target; n++)
            {
                for (m = n + 1; sum() < target; m++)
                {
                    a = (int) ( k * (Math.pow(m, 2) - Math.pow(n, 2)));
                    b = k * (2 * m * n);
                    c = (int) (k * (Math.pow(m, 2) + Math.pow(n, 2)));
                    System.out.println("a: " + a + " b: " + b + " c: " + c + " Sum: " + sum());
                }
                if (test()) break;
                reset();
            }
            if (test()) break;
            reset();
        }

        return a * b * c;
    }

    private int sum() {
        return a + b + c;
    }

    private void reset() {
        a = -1;
        b = -1;
        c = -1;
    }

    private boolean test()
    {
        return sum() == target;
    }
}

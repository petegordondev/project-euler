package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

import java.util.List;

public class S0027 implements Solution {
    private int target = 1000;
    private int ans;
    private int numPrimes = 0;

    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int original_solution() {

        // Get all primes under and equal to 1000; b has to be one of these.
        List<Integer> primesForB = PrimeHelper.getInstance().findPrimesUnder(target);

        for (Integer prime : primesForB) {
            // b must be positive, otherwise result for n = 0 will be negative and therefore not a prime.
            int b = prime;

            // Lower limits of a are determined at n = 1 (result must be 2).
            int aLow = -1 * (b + 1);

            for (int a = aLow; a < target; a++) {

                // Reset and get first result.
                int n = 0;
                int num = 0;
                int res = (n * n) + (a * n) + b;

                //Find how many primes there are.
                while (PrimeHelper.getInstance().isPrime(res)) {
                    num++;
                    n++;
                    res = (n * n) + (a * n) + b;
                }

                if (numPrimes < num) {
                    numPrimes = num;
                    ans = a * b;
                }

            }
        }
        return ans;
    }
}

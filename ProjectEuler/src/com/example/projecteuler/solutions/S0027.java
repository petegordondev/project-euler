package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

public class S0027 implements Solution {
    private int target = 1000;
    private int ans;
    private int numPrimes = 0;

    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int original_solution() {

        for(int a = -target; a <= target; a++){
            for(int b = -target; b <= target; b++){
                int n = 1;
                int num = 0;
                int res = (n*n) + (a*n) + (b*n);

                //Find how many primes there are.
                if (res > 1){
                    while (new PrimeHelper().isPrime(res)){
                        res = (n*n) + (a*n) + (b*n);
                        num++;
                        n++;
                    }

                    if (numPrimes < num){
                        numPrimes = num;
                        ans = a * b;
                    }
                }
            }
        }

        return ans;
    }
}

package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.StringHelper;

public class S0004 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {
        // Multiple 999 * 999 and start counting down.
        // Check each result if it can be reversed.

        int maxFactor = 999;
        int product;
        int palindrome = -1;

        for (int i = maxFactor; i >= 100; i--){
            for (int j = maxFactor; j >=100; j--){
                product = i * j;
                // Check if it is reversible.
                String s1 = String.valueOf(product);
                String s2 = new StringHelper().reverse(s1);

                if (s1.equals(s2)){
                    // Check if it is larger than previously found palindrome.
                    if (product > palindrome) palindrome = product;
                }
            }
        }
        return palindrome;
    }
}

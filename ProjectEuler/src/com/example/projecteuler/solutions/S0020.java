package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.ProductHelper;

public class S0020 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(original_solution());
    }

    private Integer original_solution() {
        int sum = 0;
        int target = 100;

        String product = new ProductHelper(target).factorial();

        int productLength = product.length();

        for (int n = 0; n < productLength; n++){
            sum += Character.getNumericValue(product.charAt(n));
        }

        return sum;
    }
}

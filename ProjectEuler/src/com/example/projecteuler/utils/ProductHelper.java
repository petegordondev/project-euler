package com.example.projecteuler.utils;

import java.math.BigInteger;

public class ProductHelper {

    private final int number;

    public ProductHelper(int number) {
        this.number = number;
    }

    public String factorial(){

        BigInteger product = new BigInteger(String.valueOf(1));

        for (int n = 1; n <= this.number; n++){
            BigInteger bigN = new BigInteger(String.valueOf(n));
            product = product.multiply(bigN);
        }

        return product.toString();
    }

}

package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.StringHelper;
import com.sun.corba.se.spi.activation.ServerOperations;

public class S0017 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {


        System.out.println(new StringHelper().numberAsWords(1));
        System.out.println(new StringHelper().numberAsWords(234));
        System.out.println(new StringHelper().numberAsWords(70));
        System.out.println(new StringHelper().numberAsWords(407));
        System.out.println(new StringHelper().numberAsWords(517));
        System.out.println(new StringHelper().numberAsWords(13));



        return 0;
    }
}

package com.example.projecteuler.utils;

import java.util.List;

public interface NumericalSequence {

    //Generate sequence to the nth term.
    void generate(int n);

    //Return sequence up to nth term.
    List<Integer> get(int n);

    //Sum sequence up to nth term.
    Long sum(int n);
}

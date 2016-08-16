package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

class SequenceHelper {

    //Parent class for sequence helpers.

    List<Integer> seq = new ArrayList<>();
    int n;

    SequenceHelper(int n) {
        this.n = n;
        generate();
    }

    public List<Integer> get(){
        return seq;
    }

    public long sum(){
        long sum = 0;
        for (Integer i : seq) {
            sum += i;
        }
        return sum;
    }

    private void generate() {
    }

}

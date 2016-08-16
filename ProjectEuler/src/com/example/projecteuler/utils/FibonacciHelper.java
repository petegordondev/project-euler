package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

public class FibonacciHelper extends SequenceHelper{

    private List<Integer> fList = new ArrayList<>();

    public FibonacciHelper(int n) {
        super(n);
    }

    private void generate(){
        for (int i = 0; i < n; i++){
            if (i < 2){
                seq.add(1);
            } else {
                seq.add(seq.get(i-1)+seq.get(i-2));
            }
        }
    }

}

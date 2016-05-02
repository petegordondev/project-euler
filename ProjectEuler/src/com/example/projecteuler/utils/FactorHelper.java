package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

public class FactorHelper {

    private final int number;

    public FactorHelper(int number) {
        this.number = number;
    }

    @SuppressWarnings("WeakerAccess")
    public List<Integer> getList(){
        return generate();
    }

    public int count(){
        return generate().size();
    }

    public void print(){
        for (Integer i : getList()){
            System.out.println(i);
        }
    }

    private List<Integer> generate(){
        List<Integer> l = new ArrayList<>();
        // find all factors of n.
        // Find all factors lower than square root.
        int upper = (int) Math.sqrt(number);
        for (int i = 1; i <= upper; i++){
            if (number % i == 0) l.add(i);
        }
        // Add factors above square root.
        for (int i = l.size() - 1; i >= 0; i--){
            if (l.get(i) != upper) l.add(number / l.get(i));
        }
        return l;
    }
}
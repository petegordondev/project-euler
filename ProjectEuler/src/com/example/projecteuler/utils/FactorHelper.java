package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

public class FactorHelper {

    private final int number;

    private List<Integer> l = new ArrayList<>();

    public FactorHelper(int number) {
        this.number = number;
        generate();
    }

    public List<Integer> getList(){
        return l;
    }

    public List<Integer> getProper()
    {
        List<Integer> lProper = l;

        if (lProper.size() > 0) lProper.remove(lProper.size()-1);

        return lProper;
    }

    public int count(){
        return l.size();
    }

    public int sumProper(){

        int sum = 0;

        List<Integer> lProper = getProper();

        for (Integer aL : lProper) {
            sum += aL;
        }

        return sum;
    }

    public int sum(){

        int sum = 0;

        for (Integer aL : l) {
            sum += aL;
        }

        return sum;
    }

    public void print(){
        for (Integer i : getList()){
            System.out.println(i);
        }
    }

    private void generate(){
        // find all factors of n.
        // Find all factors lower than square root.
        int upper = (int) Math.sqrt(number);
        for (int i = 1; i <= upper; i++){
            if (number % i == 0) l.add(i);
        }
        // Add factors above square root.
        for (int i = l.size() - 1; i >= 0; i--){
            int uFactor = number / l.get(i);
            if (l.get(i) != uFactor) l.add(uFactor);
        }
    }
}

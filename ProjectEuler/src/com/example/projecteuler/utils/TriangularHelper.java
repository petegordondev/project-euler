package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

public class TriangularHelper {

    // Gets the n first triangular numbers.

    private List<Integer> list = new ArrayList<>();

    public TriangularHelper() {
        list.add(1);
    }

    public int get(int n){
        if (getCount() < n) generateBatch(n);
        return list.get(n - 1);
    }

    public List<Integer> getList(int n){
        generateBatch(n);
        return list;
    }

    private int getCount(){
        return list.size();
    }

    private void generateBatch(int n){
        while (getCount() < n) generateNext();
    }

    private void generateNext(){
        // Get latest in list.
        int latest = list.get(getCount() - 1);
        // Add to latest.
        latest += getCount() + 1;
        list.add(latest);
    }
}

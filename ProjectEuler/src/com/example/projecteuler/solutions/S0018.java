package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.DataFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S0018 implements Solution {

    private int sum = 0;

    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {

        List<String> data = new DataFileHelper("D0018").toStringArray();

        // Parse strings into int arrays.

        List<List> triangle = new ArrayList<>();

        for (String triangleRow : data){
            List<Integer> row = new ArrayList<>();
            Scanner s = new Scanner(triangleRow);
            s.useDelimiter(" ");
            while (s.hasNext()){
                row.add(s.nextInt());
            }
            triangle.add(row);
        }





        return sum;
    }
}

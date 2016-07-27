package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.DataFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S0018 implements Solution {


    // Possible clever method - eliminate links that are never to be used from the bottom up.

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

        // Print triangle

//        for (List<Integer> triangleRow : triangle
//             ) {
//            for (Integer num : triangleRow
//                 ) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

        int triangleSize = triangle.size();

        // Initialize options.
        List<Integer> options = triangle.get(triangleSize-1);

        for (int row = triangle.size()-1; row > 0; row--){
            List<Integer> upper = triangle.get(row-1);
            List<Integer> lower = options;
            for (int n = 0; n < upper.size(); n++) {

                int curr = upper.get(n);
                int a = lower.get(n);
                int b = lower.get(n+1);;
                if (a > b){
                    options.set(n, curr + a);
                } else {
                    options.set(n, curr + b);
                }

                //System.out.print(num + " ");
            }
            options.remove(upper.size());
            //System.out.println();
        }

        sum = options.get(0);

        return sum;
    }
}

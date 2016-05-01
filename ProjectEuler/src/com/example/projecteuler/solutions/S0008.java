package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class S0008 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {
        int span = 13;
        long target = -1; // Max possible value is 9^13 which is bigger than int max.

        // Create ArrayList to store number. Could use HashMap.
        List<Integer> l = new ArrayList<>();

        // Read number from filw.
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/ProjectEuler/data/D0008"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        try {
            if (in != null) {
                while ((line = in.readLine()) != null) {
                    // Add each character in this line to ArrayList.
                    for (int i = 0; i < line.length(); i++){
                        l.add(Character.getNumericValue(line.charAt(i)));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start multiplying adjacent numbers within the ArrayList covered by the required span.
        // Keep record of largest multiple.

        long m = 0;
        for (int i = 0; i < (l.size()-span); i++){

            for (int j = 0; j < span; j++){
                if (j==0) {
                    m = l.get(i);
                } else m *= l.get(i + j);
            }
            if (m > target) target = m;
        }
        return (int) target;
    }
}

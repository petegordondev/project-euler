package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.StringHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class S0011 implements Solution {

    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {

        int span = 4; // Number of adjacent numbers.
        int m = 0;
        int result = -1;

        // Create dynamic 2D ListArray to hold grid.
        List<List> grid = new ArrayList<>();

        // Read number grid from file.
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/ProjectEuler/data/D0011"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        try {
            if (in != null) {
                while ((line = in.readLine()) != null) {
                    List<Integer> l = new ArrayList<>();
                    // Add each number in this line to ArrayList.
                    String num = "";
                    for (int i = 0; i < line.length(); i++){
                        if (!Character.isWhitespace(line.charAt(i)))
                        {
                            num += Character.toString(line.charAt(i));
                            if (i == line.length() - 1){
                                l.add(Integer.parseInt(num));
                            }
                        } else {
                            l.add(Integer.parseInt(num));
                            num = "";
                        }
                    }
                    grid.add(l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert to regular array.
        int[][] a = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++){
            List l = grid.get(i);
            for (int j = 0; j < l.size(); j++){
                a[i][j] = (int) l.get(j);
            }
        }

        // Perform maths (horizontal).
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length - span; j++){
                for (int k = 0; k < span; k++){
                    if (k == 0) m = a[i][j];
                    else m *= a[i][j + k];
                }
                if (m > result) result = m;
            }
        }

        // Perform maths (vertical).
        for (int i = 0; i < a.length - span; i++){
            for (int j = 0; j < a[i].length; j++){
                for (int k = 0; k < span; k++){
                    if (k == 0) m = a[i][j];
                    else m *= a[i + k][j];
                }
                if (m > result) result = m;
            }
        }

        // Perform maths (diagonal SE).
        for (int i = 0; i < a.length - span; i++){
            for (int j = 0; j < a[i].length - span; j++){
                for (int k = 0; k < span; k++){
                    if (k == 0) m = a[i][j];
                    else m *= a[i + k][j + k];
                }
                if (m > result) result = m;
            }
        }

        // Perform maths (diagonal SW).
        for (int i = 0; i < a.length - span; i++){
            for (int j = span - 1; j < a[i].length; j++){
                for (int k = 0; k < span; k++){
                    if (k == 0) m = a[i][j];
                    else m *= a[i + k][j - k];
                }
                if (m > result) result = m;
            }
        }


        return result;
    }
}

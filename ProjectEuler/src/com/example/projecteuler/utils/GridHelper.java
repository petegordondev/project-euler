package com.example.projecteuler.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GridHelper {
    public GridHelper() {
    }

    public List readFromDataFile(String dataFile){
        // Create ArrayList to store number.
        List<List> grid = new ArrayList<>();

        // Read number from file.
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/ProjectEuler/data/" + dataFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        try {
            if (in != null) {
                while ((line = in.readLine()) != null) {
                    List<Integer> l = new ArrayList<>();
                    // Add each character in this line to ArrayList.
                    for (int i = 0; i < line.length(); i++){
                        l.add(Character.getNumericValue(line.charAt(i)));
                    }
                    grid.add(l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grid;
    }
}

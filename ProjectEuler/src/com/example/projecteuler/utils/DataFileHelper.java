package com.example.projecteuler.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileHelper {

    private final String fileDirectory = System.getProperty("user.dir") + "/ProjectEuler/data/";
    private final String fileName;

    public DataFileHelper(String file) {
        this.fileName = file;
    }

    public List<String> toStringArrayLines(){
        return read();
    }

    public List<String> toStringArrayItems(String delimiter){

        List<String> list = this.toStringArrayLines();
        List<String> l = new ArrayList<>();

        for (String line : list) {
            String[] splitLine = line.split(delimiter);
            for (String item :
                    splitLine) {
                item = item.replace("\"", "");
                l.add(item);
            }
        }

        return l;
    }

    private List<String> read(){
        List<String> l = new ArrayList<>();
        // Read lines from file.
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileDirectory + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        try {
            if (in != null) {
                while ((line = in.readLine()) != null) {
                    // Add each line to ArrayList.
                        l.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return l;
    }

}

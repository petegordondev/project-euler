package com.example.projecteuler.utils;

public class StringHelper {
    public StringHelper() {
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++){
            // Get character
            char c = s.charAt(i);
            sb.insert(0, c);
        }

        return sb.toString();
    }
}

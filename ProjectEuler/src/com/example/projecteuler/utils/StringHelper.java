package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> alphabetise(List<String> list){
        List<String> aList = new ArrayList<>();

        for (String item:
             list) {
            int n = 0;
            int size = aList.size();

            if (size > 0){


                while (n < size) {
                    if (item.compareTo(aList.get(n)) < 1){
                        break;
                    }
                    n++;
                }
            }
            aList.add(n, item);

        }

        return aList;
    }

    public String numberAsWords(int number){
        StringBuilder words = new StringBuilder();

        String sNumber = Integer.toString(number);

        int length = sNumber.length();

        switch (length){
            case 1: words.append(getDigit(number));
                break;
            case 2: words.append(getTens(number));
                break;
            case 3: words.append(getHundreds(number));
                break;
            case 4: words.append("one thousand");
                break;
        }

        return words.toString();
    }

    private String getHundreds(int number) {
        StringBuilder sb = new StringBuilder();
        String sNumber = Integer.toString(number);
        int d1 = Character.getNumericValue(sNumber.charAt(0));
        int d2 = Integer.parseInt(sNumber.substring(1,3));

        sb.append(getDigit(d1)).append(" hundred");

        if (d2 != 0) {
            sb.append(" and ");
            if (d2 < 10) {
                sb.append(getDigit(d2));
            } else sb.append(getTens(d2));
        }

        return sb.toString();
    }

    private String getTens(int number) {
        StringBuilder sb = new StringBuilder();
        String sNumber = Integer.toString(number);
        int d1 = Character.getNumericValue(sNumber.charAt(0));
        int d2 = Character.getNumericValue(sNumber.charAt(1));

        switch (d1){
            case 0:
                break;
            case 1: sb.append(getTeen(number));
                break;
            case 2: sb.append("twenty");
                break;
            case 3: sb.append("thirty");
                break;
            case 4: sb.append("forty");
                break;
            case 5: sb.append("fifty");
                break;
            case 6: sb.append("sixty");
                break;
            case 7: sb.append("seventy");
                break;
            case 8: sb.append("eighty");
                break;
            case 9: sb.append("ninety");
                break;
        }

        if (d1 != 1)
            switch (d2){
                case 0:
                    break;
                default:
                    if(d1 != 0) sb.append("-");
                    sb.append(getDigit(d2));
            }

        return sb.toString();
    }

    private String getTeen(int number) {
        String teen = "";
        switch (number){
            case 10: teen = "ten";
                break;
            case 11: teen = "eleven";
                break;
            case 12: teen = "twelve";
                break;
            case 13: teen = "thirteen";
                break;
            case 14: teen = "fourteen";
                break;
            case 15: teen = "fifteen";
                break;
            case 16: teen = "sixteen";
                break;
            case 17: teen = "seventeen";
                break;
            case 18: teen = "eighteen";
                break;
            case 19: teen = "nineteen";
                break;
        }
        return teen;
    }

    // Digits
    private String getDigit(int n){
        String digit = "";
        switch (n){
            case 0: digit = "zero";
                break;
            case 1: digit = "one";
                break;
            case 2: digit = "two";
                break;
            case 3: digit = "three";
                break;
            case 4: digit = "four";
                break;
            case 5: digit = "five";
                break;
            case 6: digit = "six";
                break;
            case 7: digit = "seven";
                break;
            case 8: digit = "eight";
                break;
            case 9: digit = "nine";
                break;
        }
        return digit;
    }
}

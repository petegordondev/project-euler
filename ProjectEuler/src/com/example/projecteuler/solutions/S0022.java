package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.DataFileHelper;
import com.example.projecteuler.utils.StringHelper;

import java.util.HashMap;
import java.util.List;

public class S0022 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int original_solution() {

        int sum = 0;

        List<String> words = new DataFileHelper("D0022").toStringArrayItems(",");

        words = new StringHelper().alphabetise(words);

        for (int n = 0; n < words.size(); n++){
            sum += (n+1) * scoreWord(words.get(n));
        }

        return sum;
    }

    private int scoreWord(String word) {

        int sum = 0;

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            sum += ((int) c - 64);
        }

        return sum;

    }
}

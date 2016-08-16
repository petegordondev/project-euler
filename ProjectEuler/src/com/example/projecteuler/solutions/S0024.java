package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0024 implements Solution {
    @Override
    public String getAnswer()  {
        return original_solution();
    }
    private StringBuilder sb = new StringBuilder();
    int n = 0;
    int target = 1000000;
    private String answer = "";

    private String original_solution() {

        Integer[] list = {0,1,2,3,4,5,6,7,8,9};

        //Build a string by placing in each char from new array list.
        List<Integer> chars = new ArrayList<>(Arrays.asList(list));

        while (n < target){

            //Recursive loop.
            rec(chars);

        }
        return answer;
    }

    private void rec(List<Integer> list) {

        for (int i = 0; i < list.size(); i++){
            if (n >= target) break;
            Integer c = list.get(i);
            list.remove(i);
            sb.append(c);
            //Nexh char in string.
            rec(list);
            if (list.size() == 0){
                n++;
                if (n >= target) answer = sb.toString();
            }
            list.add(i, c);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

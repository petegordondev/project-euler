package com.example.projecteuler.solutions;

import com.example.projecteuler.Main;
import com.example.projecteuler.Solution;

public class S0030 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int target = 5;
    private int ans = 0;

    private int original_solution() {

        int[] list = new int[10];

        for (int i = 0; i < 10; i++){
            list[i] = (int) Math.pow(i, target);
        }

        int d = 1;
        int maxSum = 9;
        int sumCheck = d * list[9];
        String numCheckS = "9";
        int numCheck = Integer.valueOf(numCheckS);

        while (sumCheck >= numCheck){
            d++;
            sumCheck = d * list[9];
            numCheckS = numCheckS.concat("9");
            numCheck = Integer.valueOf(numCheckS);
            maxSum = numCheck;
        }

        for (int n = 2; n < maxSum; n++){
            int x = n;
            int sum = 0;
            int digit;
            while (x > 0){
                digit = x % 10;
                x /= 10;
                sum += list[digit];
            }
            if (sum == n) ans += n;
        }

        return ans;
    }
}

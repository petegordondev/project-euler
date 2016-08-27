package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0028 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int answer = 1;
    private int target = 1001;
    private int curr = 1;

    private int original_solution() {

        for (int width = 3; width <= target; width += 2)
        {
            int n = 0;
            while (n < 4)
            {
                curr += width-1;
                answer += curr;
                n++;
            }
        }

        return answer;
    }
}

package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0031 implements Solution {

    int coinLevel;

    int[] coins = {1,2,5,10,20,50,100,200};
    int[] purse = new int[8];

    String coinsList = "200\t100\t50\t20\t10\t5\t2\t1\t";

    int target = 200;
    int ans = 0;
    StringBuilder purseContents = new StringBuilder();

    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int original_solution() {

        coinLevel = 7;

        fillPurse();

        // Requires recursion I reckon.

        // At coin level.

        // Find out max coins that can be put into purseTotal.

        // Fill purseTotal with next level.

        // Take a coin away.

        // Fill purseTotal again.

        return ans;
    }

    private void fillPurse() {
        int purseTotal = purseTotal();
        int noOfCoins = (target - purseTotal()) / coins[coinLevel];
        while (noOfCoins > -1){
            purse[coinLevel] = noOfCoins;
            if (purseTotal() == target){
                ans++;
                for (int i = 7; i > -1; i--){
                    purseContents.append(purse[i] + "\t");
                }
                System.out.print(coinsList+"\n"+purseContents.toString()+"\n\n");
                purseContents.setLength(0);
            } else {
                if (coinLevel == 0){
                    purseContents.setLength(0);
                    purse[0] = 0;
                    break;
                }
                coinLevel--;
                fillPurse();
                coinLevel++;
            }
            noOfCoins--;
        }
    }

    private int purseTotal() {
        int sum = 0;

        for (int i = 0; i < coins.length; i++){
            sum += coins[i] * purse [i];
        }

        return sum;
    }
}

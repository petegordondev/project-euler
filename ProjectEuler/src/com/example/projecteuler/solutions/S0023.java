package com.example.projecteuler.solutions;
import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.FactorHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S0023 implements Solution {
    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private int limit = 28123;

    private int original_solution() {

        long wholeSum = 0;

        //Find all abundant numbers up to limit.
        List<Integer> lAbundant = new ArrayList<>();

        for (int n = 1; n < limit; n++){
            if (n < new FactorHelper(n).sumProper()) lAbundant.add(n);
            wholeSum += n;
        }

//        for (Integer i: lAbundant
//                ){
//            if (i % 2 != 0) System.out.println(i);
//        }

        int nAbundant = lAbundant.size();

        //Find all pair sum results (no duplicates). Stop loop when over limit.
        Set<Integer> sAbundantPairs = new HashSet<>();

        for (int i = 0; i < nAbundant; i++){

            //Add all numbers equal and larger than perfect number at index.
            for (int j = i; j < nAbundant; j++){
                int pairSum = lAbundant.get(i) + lAbundant.get(j);
                if (pairSum < limit){
                    sAbundantPairs.add(pairSum);
                } else break;
            }

        }

        //Subtract pairs sum from whole triangular sum.
        long pairSum = 0;

        for (Integer aI :
                sAbundantPairs) {
            pairSum += aI;
        }

        return (int) (wholeSum - pairSum);
    }
}

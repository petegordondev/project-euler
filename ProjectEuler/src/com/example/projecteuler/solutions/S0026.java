package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

import java.util.ArrayList;
import java.util.List;

public class S0026 implements Solution{
    private int answer;

    @Override
    public String getAnswer()  {
        return Integer.toString(original_solution());
    }

    private List<int[]> divSeq = new ArrayList<>();
    private List<Integer> seq = new ArrayList<>();
    private int cycleUpper = 0;
    private boolean isRecurring;
    private int seqStart = 0;
    private int seqLength;

    private int original_solution() {
        int target = 1000;
        for (int denom = 2; denom < target; denom++){
            boolean posRec = true;
            seq.clear();
            divSeq.clear();
            rec(denom, 1);
            StringBuilder decimals = new StringBuilder();
            for (Integer d = 1; d < seq.size(); d++){
                decimals.append(Integer.toString(seq.get(d)));
            }
//            if (isRecurring) {
//                decimals.insert(seqStart-1,"(");
//                System.out.println("1/" + denom + "\t\t" + isRecurring + "\t0." + decimals.toString() + ") " + seqLength);
//            }
//            else
//            {
//                System.out.println("1/" + denom + "\t\t" + isRecurring + "\t0." + decimals.toString());
//            }
        }
        return answer;
    }

    private void rec(int denom, int numerator) {

        seqLength = 0;
        int res = numerator / denom;
        int rem = numerator % denom;
        int[] unit = {res, rem};
        divSeq.add(unit);

        if (rem == 0) {
            seq.add(res);
            isRecurring = false;
            return;
        }

        //Recurring checker
        for (int i = 0; i < seq.size(); i++) {
            int[] check = divSeq.get(i);
            if (check[0] == res && check[1] == rem) {
                isRecurring = true;
                seqStart = i;
                int seqEnd = seq.size();
                seqLength = seqEnd - seqStart;
                if (seqLength > cycleUpper) {
                    cycleUpper = seqLength;
                    answer = denom;
                }
                return;
            }
        }
        seq.add(res);

        rec(denom, rem * 10);
    }


}

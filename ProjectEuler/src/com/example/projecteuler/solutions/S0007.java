package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;
import com.example.projecteuler.utils.PrimeHelper;

import java.util.HashMap;
import java.util.List;

public class S0007 implements Solution {
    @Override
    public String getAnswer() {
        return Integer.toString(improvedSolution());
    }

    private int improvedSolution() {
        int target = 10001;

        List<Integer> primes = PrimeHelper.getInstance().findPrimes(target);

        return primes.get(target-1);
    }

    private int originalSolution(){
        int target = 10001;
        int primeCount = 0;

        // Going to use 'Sieve of Eratosthenes' to find primes.
        HashMap<Integer, Boolean> sieve = new HashMap<>();

        // Sieve has to be stepped, because we don't know where the target prime will be found.
        int stepSize = 1000;
        int step = 0;

        // Going to store primes as they are found in an array.
        int[] primes = new int[target];

        // Find next prime using stepped 'Sieve of Eratosthenes'.
        while (primeCount < target){

            // Populate sieve for the next step (marking all values as 'true', essentially treating them all as primes before elimination).
            for (int j = step * stepSize; j < (step + 1) * stepSize; j++){
                sieve.put(j, true);
            }

            // If first step, set first two sieve values (0 and 1) to false; they ain't primes.
            if (step == 0){
                sieve.put(0, false);
                sieve.put(1, false);
            }

            // Now start eliminating non-primes for this step.
            // Get primes from array first and eliminate.
            for (int j = 0; j < primeCount; j++){
                // Get prime from array.
                int p = primes[j];
                // Set multiples of this prime to false (for the number of occurrences within this step).
                if (p != 0) {
                    for (int f = (step * stepSize) / p; f <= ((step + 1) * stepSize) / p; f++) {
                        // Gotta skip f = 1; that's out prime for goodness sake!
                        if (f != 1) {
                            int m = p * f;
                            sieve.put(m, false);
                        }
                    }
                }
            }

            // Find new primes.
            for (int j = step * stepSize; j < (step + 1) * stepSize; j++){
                // Check if value is a prime.
                if (sieve.get(j)) {
                    // Set multiples of this prime to false (for the number of occurrences within this step).
                    if (j != 0) {
                        for (int f = (step * stepSize) / j; f <= ((step + 1) * stepSize) / j; f++) {
                            // Gotta skip f = 1; that's out prime for goodness sake!
                            if (f != 1) {
                                int m = j * f;
                                sieve.put(m, false);
                            }
                        }
                        // Newly found prime into array from sieve.
                        if (primeCount == target){
                            break;
                        } else {
                            primes[primeCount] = j;
                            primeCount++;
                        }
                    }
                }
            }
            step++;
        }

        return primes[target - 1];
    }
}

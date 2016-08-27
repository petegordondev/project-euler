package com.example.projecteuler.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.BooleanSupplier;

public class PrimeHelper {

    private static volatile PrimeHelper instance;

    private List<Integer> primesList;
    // Sieve has to be stepped, because we don't know where the nth prime will be found.
    private int stepSize = 1000;
    private int step;

    // Going to use 'Sieve of Eratosthenes' to find primes.
    private HashMap<Integer, Boolean> sieve;

    private PrimeHelper() {
        primesList = new ArrayList<>();
        step = 0;
        sieve = new HashMap<>();
    }

    public static PrimeHelper getInstance()
    {
        if (instance == null) instance = new PrimeHelper();
        return instance;
    }

    public List<Integer> findPrimes(int n) // Returns an array with the first n primes.
    {
        if (primesList.size() >= n)
        {
            return primesList.subList(0, n);
        }

        // Need to add new primes.
        addPrimes(n);

        return primesList.subList(0, n);
    }

    public List<Integer> findPrimesUnder(int target)
    {
        int size = primesList.size();
        if (size > 0){
            if (primesList.get(size-1) >= target)
            {
                for (int i = 0; i < primesList.size(); i++) {
                    if (primesList.get(i) > target) return primesList.subList(0, i);
                }
            }
        }

        // Need to add new primes.
        addPrimesUnder(target);

        int index = 0;
        for (int i = 0; i < primesList.size(); i++) {
            index = i+1;
            if (primesList.get(i) > target) {
                index = i;
                break;
            }
        }
        return primesList.subList(0, index);
    }

//    //TODO Proper prime checking method 'isPrime()' by using field arrays.
//    public boolean isPrime(int n){
//        if (n == 2) return true;
//        int[] primes = findPrimesUnder(n);
//        for (int i = 0; i <= primes.length/2; i++){
//            if (n%primes[i] == 0) return false;
//        }
//        return true;
//    }

    private void addPrimes(int n)
    {
        // Find next prime using stepped 'Sieve of Eratosthenes'.
        while (primesList.size() < n)
        {
            sieve();
        }
    }

    private void addPrimesUnder(int target) // Finds all primes lower than target.
    {
        while (step * stepSize < target)
        {
            sieve();
        }
    }

    private void sieve() {

        // Populate sieve for the next step (marking all values as 'true', essentially treating them all as primes before elimination).
        for (int i = step * stepSize; i < (step + 1) * stepSize; i++){
            sieve.put(i, true);
        }

        // If first step, set first two sieve values (0 and 1) to false; they ain't primes.
        if (step == 0){
            sieve.put(0, false);
            sieve.put(1, false);
        }

        // Now start eliminating non-primes for this step.
        // Get primes from array first and eliminate.
        for (Integer aL : primesList) {
            // Get prime from array.
            int p = aL;
            // Set multiples of this prime to false (for the number of occurrences within this step).
            for (int f = (step * stepSize) / p; f <= ((step + 1) * stepSize) / p; f++) {
                // Gotta skip f = 1; that's out prime for goodness sake!
                if (f != 1) {
                    int m = p * f;
                    sieve.put(m, false);
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
                        // Gotta skip f = 1; that's our prime for goodness sake!
                        if (f != 1) {
                            int m = j * f;
                            sieve.put(m, false);
                        }
                    }
                    // Newly found prime into array from sieve.
                    primesList.add(j);
                }
            }
        }
        step++;
        sieve.clear();
    }
}

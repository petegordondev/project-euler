package com.example.projecteuler;

import java.util.HashMap;

class Solutions {

    Solutions() {
    }

    public int S0001() {

        int sum = 0;

        for (int i = 0; i < 1000; i++){
            if (i%3 == 0 || i%5 == 0){
                sum = sum + i;
            }
        }

        return sum;
    }

    public int S0002() {

        int seq;
        int sum = 0;
        int curr = 1;
        int prev = 0;
        int lim = 4000000;

        while (sum < lim){

            if (curr%2 == 0) sum = sum + curr;

            seq = prev + curr;
            prev = curr;
            curr = seq;
        }

        return sum;
    }

    public int S0003() {

/* Original solution
        // Find primes starting with the smallest (2).
        // See if each prime will divide neatly into the target (600851475143).
        // If so keep this prime candidate recorded.
        // Stop when prime candidate value exceeds half of target and return the stored prime value.

        long target = 600851475143L;
        long targetHalf = target / 2;
        int prime = 0; // Might have to change data type if numbers get too large.

        // Going to use 'Sieve of Eratosthenes' to find all primes between 2 and targetHalf.
        HashMap<Long, Boolean> sieve = new HashMap<Long, Boolean>();

        // Populate sieve (marking all values as 'true', essentially trating them all as primes before elimination).
        for (long l = 2; l <= targetHalf; l++){
            sieve.put(l, true);
        }

        // Eliminate multiples of each prime.
        // Could check if prime is valid for solution in this loop, but I may need to find primes in future and reuse this code.
        for (long l = 2; l <= targetHalf; l++){
            // Check if value is a prime.
            if (sieve.get(l) == true){
                // Set multiples of this prime to false (for the number of occurrences within targetHalf).
                for (int f = 2; f <= (targetHalf/l); f++)  {
                    long m = f * l;
                    sieve.put(m, false);
                }
            }
        }

        // Check if primes are multiples of target and store largest.
        for (long l = 2; l <= targetHalf; l++){
            // Check if value divides into target.
            if (sieve.get(l) == true && target%l == 0){
                // Set prime.
                prime = (int) l;
            }
        }

        return prime;
        */


        // Target = 600851475143.
        long target = 600851475143L;
        boolean largestPrimeFound = false;

        // We are looking for largest factor that is prime.
        // Cycle through largest potential factors of target, by dividing by smallest potential factors.

        long smallFactor = 2; // Initial smallest factor of a composite number.
        long largeFactor = -1; // Initialising our largest factor variable.
        while ((smallFactor < target/2) && !largestPrimeFound)
        {
            largeFactor = target / smallFactor;
            // Check that it is a factor of target.
            if (target % largeFactor == 0){
                // Check that it is a prime.
                boolean prime = true;
                // A composite number will always have a factor less than or equal to its square root.
                for (long f = (long) Math.sqrt((double) largeFactor); f >= 2; f--){
                    if (largeFactor%f == 0) { //Not a prime.
                        prime = false;
                        break;
                    }
                }
                if (prime) largestPrimeFound = true;
            }
            smallFactor++;
        }

        return (int) largeFactor;
    }
}

package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0019 implements Solution {

    private int sum = 0;
    private int month = 1;
    private int year = 1900;

    @Override
    public String getAnswer() {
        return Integer.toString(originalSolution());
    }

    private int originalSolution() {

//        1 Jan 1900 was a Monday.
//                Thirty days has September,
//                April, June and November.
//        All the rest have thirty-one,
//                Saving February alone,
//        Which has twenty-eight, rain or shine.
//        And on leap years, twenty-nine.
//                A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

        // Start at 7 Jan 1900 (which was a Sunday, if 1 Jan 1900 was a Monday).
        // Keep cycling forward 7 days, updating date values (day, month, year).
        // To keep daes right, keep testing rules.
        // Test if 1st of each month, add to sum if true.

        // Start at 7 Jan 1900 (which was a Sunday, if 1 Jan 1900 was a Monday).
        int dayOfMonth = 7;


        // Keep cycling forward 7 days, updating date values (day, month, year).

        while (isTwentieth() || sum == 0){

            if (dayOfMonth + 7 <= daysInMonth()){
                dayOfMonth += 7;
            } else {
                dayOfMonth += 7 - daysInMonth();
                if (month + 1 <= 12){
                    month++;
                }else{
                    month = 1;
                    year++;
                }

            }

            if (isTwentieth() && checkSunday(dayOfMonth)) sum++;

        }



        // To keep daes right, keep testing rules.
        // Test if 1st of each month, add to sum if true.


        return sum;
    }

    private boolean checkSunday(int dayOfMonth) {
        return (dayOfMonth == 1);
    }

    private int daysInMonth() {

        int days;

        if (month == 4 || month == 6 || month == 9 || month == 11) days = 30;
        else if (month == 2){
            if (year % 4 == 0){
                if (year % 100 == 0 && year % 400 != 0){
                    days = 28;
                }
                else days = 29;
            } else days = 28;
        } else days = 31;

        return days;
    }

    private boolean isTwentieth () {
        return year > 1900 && year < 2001;
    }
}

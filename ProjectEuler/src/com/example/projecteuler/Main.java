package com.example.projecteuler;

import com.example.projecteuler.solutions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {


    private static int n;
    private static Scanner sc = new Scanner(System.in);
    private static int numSolved = 8;
    private static boolean userActive = true;

    public static void main(String[] args) {
        System.out.println("Welcome to Pete's answers to Project Euler problems." +
                "\nI've so far completed exercises 1 to " + numSolved + ", so only choose a problem in this range.");

        while (userActive) requestSolution();

    }

    private static void requestSolution(){

        System.out.print("Please enter a problem number for an answer (or type 'exit' to quit): ");

        if (sc.hasNextInt()) {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Not a positive integer.");
            } else if (n > numSolved) {
                System.out.println("No solution available.");
            } else {
                System.out.println("You have requested answer for problem number " + n + ".");
                int ans = loadSolution(n);
                System.out.println("Answer: " + ans);
            }
        } else {
            if (sc.hasNext("exit")){
                userActive = false;
            }
            else System.out.println("Not a valid integer.");
            sc.next();
        }
    }

    private static int loadSolution(int n) {



        Solutions s = new Solutions();
        Method method = null;
        int r = 0;

        try {
            method = s.getClass().getMethod("S000" + n);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            if (method != null) {
                r = (int) method.invoke(s);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return r;
    }

        ClassLoader classLoader = Main.class.getClassLoader();

        try {
            Class aClass = classLoader.loadClass("com.jenkov.MyClass");
            System.out.println("aClass.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

package com.example.projecteuler;

import java.io.File;
import java.util.Scanner;

public class Main {


    private static int n;
    private static Scanner sc = new Scanner(System.in);

    private static int numSolved = new File(System.getProperty("user.dir") + "/ProjectEuler/src/com/example/projecteuler/solutions").list().length;
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
                long startTime = System.nanoTime();
                String ans = loadSolution(n);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime)/1000000;
                System.out.println("Answer: " + ans);
                System.out.println("Time for execution: " + duration + " ms");
            }
        } else {
            if (sc.hasNext("exit")){
                userActive = false;
            }
            else System.out.println("Not a valid integer.");
            sc.next();
        }
    }

    private static String loadSolution(int n){

        String answer = "";
        ClassLoader classLoader = Main.class.getClassLoader();

        String sClass = "S" + String.format("%04d", n);

        Class aClass = null;
        try {
            aClass = classLoader.loadClass("com.example.projecteuler.solutions." + sClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Solution solution = null;
            if (aClass != null) {
                solution = (Solution) aClass.newInstance();
            }
            if (solution != null) {
                answer = solution.getAnswer();
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return answer;
    }


}

package com.java.Experiment6;

import java.util.Scanner;

public class Multiplication {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Calculate square
        int square = num * num;

        // Display square
        System.out.println("Square of " + num + " is: " + square);

        // Display multiplication table
        System.out.println("\nMultiplication Table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        // Close scanner
        sc.close();
    }
}
package com.nighthawk.spring_portfolio.mvc.Fibonacci;

public class FibonacciRecursive {
    public static long[] calculateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. N should be a positive integer.");
            return null;
        }

        long[] fibSequence = new long[n + 1];
        calculateFibonacciRecursive(n, fibSequence);

        return fibSequence;
    }

    private static long calculateFibonacciRecursive(int n, long[] fibSequence) {
        if (n == 0) {
            fibSequence[0] = 0;
            return 0;
        } else if (n == 1) {
            fibSequence[1] = 1;
            return 1;
        } else {
            fibSequence[n] = calculateFibonacciRecursive(n - 1, fibSequence) + calculateFibonacciRecursive(n - 2, fibSequence);
            return fibSequence[n];
        }
    }
}
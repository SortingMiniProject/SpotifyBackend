package com.nighthawk.spring_portfolio.mvc.Fibonacci;

public class FibonacciFor {
    public static long[] calculateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. N should be a positive integer.");
            return null;
        }

        long[] fibSequence = new long[n + 1];
        fibSequence[0] = 0;
        fibSequence[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
        }

        return fibSequence;
    }
}
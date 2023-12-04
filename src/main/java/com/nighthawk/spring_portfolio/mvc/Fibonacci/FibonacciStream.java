package com.nighthawk.spring_portfolio.mvc.Fibonacci;

import java.util.stream.Stream;

public class FibonacciStream extends Fibonacci {
    public static long[] calculateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. N should be a positive integer.");
            return null;
        }

        return Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(n + 1)
                .mapToLong(f -> f[0])
                .toArray();
    }
}
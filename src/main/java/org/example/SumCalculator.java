package org.example;

public class SumCalculator {
    public int sum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else {
            int sum = 1;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
    }
}

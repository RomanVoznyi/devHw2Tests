package org.example;

public class SumCalculator {
    public int sum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else {
            if (n > 65000) {
                System.out.println("The result obtained with a high degree of probability is incorrect " +
                        "due to the limitation of the capacity of the int type. We recommend using the function " +
                        "'long sum(long n)' for such big numbers");
            }
            int sum = 1;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public long sum(long n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else {
            return (1 + n) * n / 2l;
        }
    }
}

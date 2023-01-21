package org.example;

public class Main {
    public static void main(String[] args) {
        SumCalculator calc = new SumCalculator();

        System.out.println(calc.sum(1)); // should be 1
        System.out.println(calc.sum(5)); // should be 15
        try {
            System.out.println(calc.sum(-1)); // should throw Exception
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
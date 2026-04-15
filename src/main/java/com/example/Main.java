package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GradeCalculator calc = new GradeCalculator();

        List<Double> scores = Arrays.asList(8.0, 9.0, 7.5, 6.5);
        double avg = calc.calculateAverage(scores);
        String rank = calc.classify(avg);

        System.out.println("Điểm trung bình: " + avg);
        System.out.println("Xếp loại: " + rank);
    }
}
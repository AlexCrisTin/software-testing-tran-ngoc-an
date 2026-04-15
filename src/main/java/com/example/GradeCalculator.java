package com.example;

import java.util.List;

public class GradeCalculator {

    // VÒNG LẶP: duyệt danh sách điểm
    public double calculateAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.size();
    }

    // RẼ NHÁNH: xếp loại học lực
    public String classify(double average) {
        if (average >= 9.0) {
            return "Xuất sắc";
        } else if (average >= 8.0) {
            return "Giỏi";
        } else if (average >= 6.5) {
            return "Khá";
        } else if (average >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    public boolean isValidScore(double score) {
        return score >= 0.0 && score <= 10.0;
    }

    public String evaluate(List<Double> scores) {
        double avg = calculateAverage(scores);
        return classify(avg);
    }
}
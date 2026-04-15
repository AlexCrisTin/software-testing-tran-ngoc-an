package com.example;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Issue #1 - Statement Coverage")
class GradeCalculatorStatementTest {

    private GradeCalculator calc;

    @BeforeEach
    void setUp() { calc = new GradeCalculator(); }

    // --- calculateAverage ---
    @Test void test_NullList()  { assertEquals(0.0, calc.calculateAverage(null), 0.001); }
    @Test void test_EmptyList() { assertEquals(0.0, calc.calculateAverage(List.of()), 0.001); }
    @Test void test_ValidList() { assertEquals(8.0, calc.calculateAverage(List.of(8.0,9.0,7.0)), 0.001); }

    // --- classify (mỗi return được chạy ít nhất 1 lần) ---
    @Test void test_XuatSac()   { assertEquals("Xuất sắc",   calc.classify(9.5)); }
    @Test void test_Gioi()      { assertEquals("Giỏi",       calc.classify(8.5)); }
    @Test void test_Kha()       { assertEquals("Khá",        calc.classify(7.0)); }
    @Test void test_TrungBinh() { assertEquals("Trung bình", calc.classify(5.5)); }
    @Test void test_Yeu()       { assertEquals("Yếu",        calc.classify(3.0)); }

    // --- isValidScore ---
    @Test void test_ValidScore()   { assertTrue(calc.isValidScore(7.5));   }
    @Test void test_InvalidScore() { assertFalse(calc.isValidScore(-1.0)); }

    // --- evaluate ---
    @Test void test_Evaluate() {
        assertEquals("Xuất sắc", calc.evaluate(List.of(9.0, 9.5, 8.5)));
    }
}

package com.example;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Issue #2 - Path Coverage")
class GradeCalculatorPathTest {

    private GradeCalculator calc;

    @BeforeEach
    void setUp() { calc = new GradeCalculator(); }

    // --- calculateAverage: 4 đường đi ---
    @Test void path_Null()         { assertEquals(0.0, calc.calculateAverage(null), 0.001); }
    @Test void path_Empty()        { assertEquals(0.0, calc.calculateAverage(List.of()), 0.001); }
    @Test void path_OneElement()   { assertEquals(5.0, calc.calculateAverage(List.of(5.0)), 0.001); }
    @Test void path_MultiElement() { assertEquals(7.0, calc.calculateAverage(List.of(6.0,7.0,8.0)), 0.001); }

    // --- classify: kiểm tra giá trị biên từng nhánh ---
    @Test void path_XuatSac_Boundary() { assertEquals("Xuất sắc",   calc.classify(9.0));  }
    @Test void path_XuatSac_Above()    { assertEquals("Xuất sắc",   calc.classify(10.0)); }
    @Test void path_Gioi_Boundary()    { assertEquals("Giỏi",       calc.classify(8.0));  }
    @Test void path_Gioi_Mid()         { assertEquals("Giỏi",       calc.classify(8.9));  }
    @Test void path_Kha_Boundary()     { assertEquals("Khá",        calc.classify(6.5));  }
    @Test void path_Kha_Mid()          { assertEquals("Khá",        calc.classify(7.9));  }
    @Test void path_TrungBinh_Bound()  { assertEquals("Trung bình", calc.classify(5.0));  }
    @Test void path_TrungBinh_Mid()    { assertEquals("Trung bình", calc.classify(6.4));  }
    @Test void path_Yeu_Boundary()     { assertEquals("Yếu",        calc.classify(4.9));  }
    @Test void path_Yeu_Zero()         { assertEquals("Yếu",        calc.classify(0.0));  }

    // --- isValidScore: cả 2 nhánh true/false ---
    @Test void path_Valid_Lower()   { assertTrue(calc.isValidScore(0.0));    }
    @Test void path_Valid_Upper()   { assertTrue(calc.isValidScore(10.0));   }
    @Test void path_Invalid_Below() { assertFalse(calc.isValidScore(-0.1)); }
    @Test void path_Invalid_Above() { assertFalse(calc.isValidScore(10.1)); }

    // --- evaluate: đường đi kết hợp ---
    @Test void path_Evaluate_Kha() {
        assertEquals("Khá", calc.evaluate(List.of(7.0, 6.5, 7.5)));
    }
    @Test void path_Evaluate_Empty() {
        assertEquals("Yếu", calc.evaluate(List.of()));  // avg=0.0 -> Yếu
    }
}
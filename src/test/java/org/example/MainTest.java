package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Main main;

    private static final double EPS = 1e-9;

    @BeforeEach
    void setUp(){
        main = new Main();
    }

    @Test
    void testCalculateFunction() {
        double x = 1;
        double res = main.calculateFunction(x);
        double expected = 6.4;
        assertEquals(expected, res, EPS);
    }

    @ParameterizedTest
    @CsvSource (value = {"0.0, 4.0",
                         "1.0, 6.4",
                         "1.3, 8.173000000000002",
    "1.4, 3.6490364819799543",
    "1.5, 1.2480754415067656",
    "10, -0.02985111570629966",
    "25, -0.19184658407458355",
    "100, -0.2729863510236647"})
    void testCalculateFParam(double x, double expected){
        assertEquals(expected, main.calculateFunction(x), EPS);
    }

    @Test
    void testStepsAmount() {
        double start = 0.0;
        double end = 2.0;
        double step = 0.002;
        double res = main.stepsAmount(start,end,step);
        double expected = 1000;
        assertEquals(expected, res, EPS);
    }
}
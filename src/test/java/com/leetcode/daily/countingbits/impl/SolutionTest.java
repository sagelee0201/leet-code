package com.leetcode.daily.countingbits.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void test() {
        int n = 2;
        int[] expected = {0, 1, 1};

        int[] ans = solution.countBits(n);

        Assertions.assertTrue(Arrays.equals(ans, expected));
    }

    @Test
    public void randomTest() {
        int n = 10;

        int[] ans = solution.countBits(n);

        Arrays.stream(ans).forEach(System.out::println);
    }

    @Test
    public void scanAndSumElementsTest() {
        int[] arrToScan = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        int[] expected = {1, 2, 3, 4, 5, 2, 3, 4, 5, 6};

        solution.scanAndAddOneElements(arrToScan, 5, 10);

        Assertions.assertTrue(Arrays.equals(arrToScan, expected));
    }
}
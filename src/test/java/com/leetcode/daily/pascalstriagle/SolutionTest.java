package com.leetcode.daily.pascalstriagle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final SolutionToTest solution = new SolutionToTest();

    @Test
    public void basicTestCase_0() {
        //5
        //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        final int numRows = 5;
        final List<List<Integer>> expected = List.of(List.of(1),
                List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1));

        final List<List<Integer>> result = solution.generate(numRows);

        assertTrue(deepEquals(result, expected));
    }

    @Test
    public void basicTestCase_1() {
        //1
        //[[1]]
        final int numRows = 1;
        final List<List<Integer>> expected = List.of(List.of(1));

        final List<List<Integer>> result = solution.generate(numRows);

        assertTrue(deepEquals(result, expected));
    }

    @Test
    public void generateSingleRow() {
        //[1,3,3,1]
        //[1,4,6,4,1]
        final List<Integer> input = List.of(1, 3, 3, 1);
        final List<Integer> expected = List.of(1, 4, 6, 4, 1);

        final List<Integer> result = solution.generate(input);

        assertTrue(equals(result, expected));
    }

    private boolean deepEquals(List<List<Integer>> a, List<List<Integer>> b) {
        if (a.size() != b.size()) {
            return false;
        }

        for (int i = 0; i < a.size(); i++) {
            if (!equals(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean equals(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }


    static class SolutionToTest extends Solution {
        public List<Integer> generate(List<Integer> row) {
            return super.generate(row);
        }
    }

}
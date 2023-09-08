package com.leetcode.daily.minimumpenaltyforashop.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void numberOfCharFromStart() {
        // Given
        final String customers = "NNYYNY";
        final int[] expectedNs = new int[]{1, 2, 2, 2, 3, 3};
        int curPenalty = 0;

        // When
        int[] ns = solution.numberOfCharFromStart(customers, 'N');

        // Then
        for(int i = 0; i < customers.length(); i++) {
            // Then
            Assertions.assertEquals(expectedNs[i], ns[i]);
        }
    }

    @Test
    public void curMinCostIfClosed() {
        // Given
//        final String customers = "NNYYYY";
//        final int[] expectedMinPenalty = new int[]{0, 0, 1, 2, 3, 4};
//        int curPenalty = 0;
//
//        for(int i = 0; i < customers.length(); i++) {
//            // When
//            curPenalty = solution.curMinPenaltyIfClosed(customers, i, curPenalty);
//
//            // Then
//            Assertions.assertEquals(curPenalty, expectedMinPenalty[i]);
//        }
    }

    @Test
    public void bestClosingTime() {
        // Given
        final String customers = "NNYYYY";

        // When
        int index = solution.bestClosingTime(customers);

        // Then
        Assertions.assertEquals(index, 5);
    }

    @Test
    public void bestClosingTimeEnd() {
        // Given
        final String customers = "YYYY";

        // When
        int index = solution.bestClosingTime(customers);

        // Then
        Assertions.assertEquals(index, 4);
    }
}
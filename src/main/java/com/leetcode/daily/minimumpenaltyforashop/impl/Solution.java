package com.leetcode.daily.minimumpenaltyforashop.impl;

public class Solution {
    public int bestClosingTime(String customers) {
        int length = customers.length();
        int minPenalty = length;
        int minIndex = 0;

        int[] nFromStart = numberOfCharFromStart(customers, 'N');
        int[] yFromEnd = numberOfCharFromEnd(customers, 'Y');

        minPenalty = yFromEnd[0];

        for (int i = 1; i < length; i++) {
            int curPenalty = nFromStart[i - 1] + yFromEnd[i];
            if (minPenalty > curPenalty) {
                minPenalty = curPenalty;
                minIndex = i;
            }
        }

        if (minPenalty > nFromStart[length - 1]) {
            return length;
        }

        return minIndex;
    }

    public int[] numberOfCharFromStart(String customers, char c) {
        int length = customers.length();
        int[] numberOfChar = new int[length];
        int curNum = 0;

        for (int i = 0; i < length; i++) {
            if (customers.charAt(i) == c) {
                curNum++;
            }
            numberOfChar[i] = curNum;
        }
        //"YYNN"
        //
        return numberOfChar;
    }

    public int[] numberOfCharFromEnd(String customers, char c) {
        int length = customers.length();
        int[] numberOfChar = new int[length];
        int curNum = 0;

        for (int i = 0; i < length; i++) {
            if (customers.charAt(length - 1 - i) == c) {
                curNum++;
            }
            numberOfChar[length - 1 - i] = curNum;
        }
        return numberOfChar;
    }
}

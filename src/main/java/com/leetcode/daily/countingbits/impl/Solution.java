package com.leetcode.daily.countingbits.impl;

public class Solution {
    public int[] countBits(int n) {
        int index = 1;
        int curPower = 1;
        int[] ans = new int[n + 1];

        while (curPower <= n) {
            int endIndex = Math.min(index + curPower, n + 1);
            scanAndAddOneElements(ans, index, endIndex);
            index = index + curPower;
            curPower = curPower * 2;
        }

        return ans;
    }

    public void scanAndAddOneElements(int[] ans, int startIndex, int endIndex) {
        for (int i = 0; i < endIndex - startIndex; i++) {
            ans[startIndex + i] = ans[i] + 1;
        }
    }
}

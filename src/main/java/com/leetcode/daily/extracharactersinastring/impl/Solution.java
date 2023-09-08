package com.leetcode.daily.extracharactersinastring.impl;

import java.util.*;

public class Solution {


    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        // dp[i] := i - 1 까지의 minExtraChar
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                // s[j..i) is in dictionarySet.
                if (dictionarySet.contains(s.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
                    // s[j..i) are extra characters.
                else
                    dp[i] = Math.min(dp[i], dp[j] + i - j);

        return dp[n];
    }
    public int minExtraChar_(String s, String[] dictionary) {
        final int dictionaryLen = dictionary.length;
        final boolean[] included = new boolean[s.length()];

        for (int i = 0; i < dictionaryLen; i++) {
            final String target = dictionary[i];
            final List<Integer> idxList = findTargetInString(s, target);
            if (!idxList.isEmpty()) {
                System.out.println("==================");
                System.out.println("target: " + target);
                idxList.stream()
                        .forEach(idx -> {
                            System.out.println("idx: " + idx);
                        });
            }
            idxList.stream().forEach(idx -> {
                checkIfIncludedInTarget(included, target.length(), idx);
            });
        }
        for (int i = 0; i < included.length; i++) {
            System.out.println(i + ": " + included[i]);
        }
        return countFalse(included);
    }

    public int countFalse(boolean[] boolArr) {
        final int len = boolArr.length;
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (!boolArr[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    public void checkIfIncludedInTarget(boolean[] included, int targetLen, int startIdx) {
        for (int i = 0;  i < targetLen; i++) {
            included[startIdx + i] = true;
        }
    }

    public List<Integer> findTargetInString(String s, String target) {
        final List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (findTargetInStringFrom(s, target, i)) {
                indices.add(i);
            }
        }
        return indices;
    }

    public boolean findTargetInStringFrom(String s, String target, int index) {
        final int targetLen = target.length();

        if (index + targetLen > s.length()) {
            return false;
        }

        for (int i = 0; i < targetLen; i++) {
            if (s.charAt(index + i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

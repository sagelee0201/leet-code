package com.leetcode.daily.extracharactersinastring.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void minExtraChar_0() {
        final String s = "kevlplxozaizdhxoimmraiakbak";
        final String[] dictionary = {"yv","bmab","hv","bnsll","mra","jjqf","g","aiyzi","ip","pfctr","flr","ybbcl","biu","ke","lpl","iak","pirua","ilhqd","zdhx","fux","xaw","pdfvt","xf","t","wq","r","cgmud","aokas","xv","jf","cyys","wcaz","rvegf","ysg","xo","uwb","lw","okgk","vbmi","v","mvo","fxyx","ad","e"};

        int ans = solution.minExtraChar(s, dictionary);

        assertEquals(ans, 9);

//        0: t
//        1: t
//        2: t
//        3: t
//        4: t
//        5: t
//        6: t
//        7: t
//        8: false
//        9: false
//        10: false
//        11: t
//        12: t
//        13: t
//        14: t
//        15: t
//        16: false
//        17: false
//        18: t
//        19: t
//        20: t
//        21: t
//        22: t
//        23: t
//        24: false
//        25: false
//        26: false
    }

    @Test
    public void minExtraChar_1() {
        final String s = "leetscode";
        final String[] dictionary = {"leet","code","leetcode"};

        int ans = solution.minExtraChar(s, dictionary);

        assertEquals(ans, 1);
    }

    @Test
    public void minExtraChar_2() {
        final String s = "sayhelloworld";
        final String[] dictionary = {"hello","world"};

        int ans = solution.minExtraChar(s, dictionary);

        assertEquals(ans, 3);
    }

    @Test
    public void minExtraChar_3() {
        final String s = "xtcsgdelqbxxhfubvorjfsyuqcgsyuqcgplf";
        final String[] dictionary = {"lkycpd","emj","fj","syuqcg","hrn","c","j","csgdel","o","xhfubv","lo","yoommo","zmef","ual","kolx","qgyrwj","im","jgs","f","knhihb","qbx","qg","uhft","wurdt"};

        int ans = solution.minExtraChar(s, dictionary);

        assertEquals(ans, 5);
    }

    @Test
    public void minExtraChar_4() {
        final String s = "lllll";
        final String[] dictionary = {"ll"};

        int ans = solution.minExtraChar(s, dictionary);

        assertEquals(ans, 0);
    }

    @Test
    public void countFalse() {
        final boolean[] boolArr = {false, true, true, true, true};

        final int cnt = solution.countFalse(boolArr);

        assertEquals(cnt, 1);
    }

    @Test
    public void checkIfIncludedInTarget() {
        final boolean[] included = new boolean[5];
        final boolean[] expected = {false, true, true, true, true};

        solution.checkIfIncludedInTarget(included, 4, 1);

        assertTrue(Arrays.equals(included, expected));
    }

    @Test
    public void findTargetInString_1() {
        final String string = "leetsleet";
        final String target = "leet";
        final List<Integer> expected = List.of(0, 5);

        final List<Integer> targetIdxList = solution.findTargetInString(string, target);

        assertEquals(expected, targetIdxList);
    }

    @Test
    public void findTargetInString_1_1() {
        final String string = "lleet";
        final String target = "leet";
        final List<Integer> expected = List.of(1);

        final List<Integer> targetIdxList = solution.findTargetInString(string, target);

        assertEquals(expected, targetIdxList);
    }

    @Test
    public void findTargetInString_2() {
        final String string = "sleet";
        final String target = "leet";
        final List<Integer> expected = List.of(1);

        final List<Integer> targetIdxList = solution.findTargetInString(string, target);

        assertEquals(expected, targetIdxList);
    }

    @Test
    public void findTargetInStringFrom() {
        final String string = "sleet";
        final String target = "leet";

        final boolean ifTargetExist = solution.findTargetInStringFrom(string, target, 1);

        assertTrue(ifTargetExist);
    }

    @Test
    public void findTargetInStringFrom_No_Index_Out_Of_Bound_Exception() {
        final String string = "sleet";
        final String target = "leet";

        final boolean ifTargetExist = solution.findTargetInStringFrom(string, target, 2);

        assertFalse(ifTargetExist);
    }

}
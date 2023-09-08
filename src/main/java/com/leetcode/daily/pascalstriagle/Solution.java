package com.leetcode.daily.pascalstriagle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> generated = new ArrayList<>();
        final List<Integer> firstRow = List.of(1);
        generated.add(firstRow);

        List<Integer> lastList = firstRow;
        for (int i = 1; i < numRows; i++) {
            final List<Integer> generateRow = generate(lastList);
            generated.add(generateRow);
            lastList = generateRow;
        }

        return generated;
    }

    protected List<Integer> generate(List<Integer> row) {
        final List<Integer> generated = new ArrayList<>();
        generated.add(1);
        for (int i = 0; i < row.size() - 1; i++) {
            generated.add(row.get(i) + row.get(i + 1));
        }
        generated.add(1);
        return generated;
    }
}

package leetcode.leetcode23xx.leetcode2363;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX_VAl = 1000;

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] weightSum = new int[MAX_VAl + 1];
        for (int[] item : items1) weightSum[item[0]] += item[1];
        for (int[] item : items2) weightSum[item[0]] += item[1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= MAX_VAl; i++) if (weightSum[i] != 0) ans.add(List.of(i, weightSum[i]));
        return ans;
    }
}

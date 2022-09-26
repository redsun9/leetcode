package leetcode.leetcode24xx.leetcode2418;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) arr[i] = new Pair(heights[i], i);
        Arrays.sort(arr, Comparator.comparingInt(Pair::height));
        String[] ans = new String[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) ans[j] = names[arr[i].index];
        return ans;
    }

    private record Pair(int height, int index) {
    }
}

package leetcode.leetcode11xx.leetcode1122;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = arr2.length; i < n; i++) {
            map.put(arr2[i], i);
        }
        Integer[] indices = new Integer[arr1.length];
        for (int i = 0, n = arr1.length; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(x -> map.getOrDefault(arr1[x], 10000 + arr1[x])));
        int[] ans = new int[arr1.length];
        for (int i = 0, n = arr1.length; i < n; i++) {
            ans[i] = arr1[indices[i]];
        }
        return ans;
    }
}

package leetcode.leetcode12xx.leetcode1200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = arr[1] - arr[0];
        for (int i = 2; i < n; i++) min = Math.min(min, arr[i] - arr[i - 1]);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == min) ans.add(List.of(arr[i - 1], arr[i]));
        }
        return ans;
    }
}

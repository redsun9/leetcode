package leetcode.leetcode23xx.leetcode2389;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length, m = nums.length;
        int[][] arrQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrQueries[i][0] = queries[i];
            arrQueries[i][1] = i;
        }
        Arrays.sort(arrQueries, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(nums);
        int[] ans = new int[n];
        int s = 0, count = 0;
        for (int[] arrQuery : arrQueries) {
            int threshold = arrQuery[0];
            while (count < m && s <= threshold) s += nums[count++];
            ans[arrQuery[1]] = s <= threshold ? count : count - 1;
        }
        return ans;
    }
}

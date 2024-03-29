package leetcode.leetcode30xx.leetcode3074;

import java.util.Arrays;

public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        long sum = 0;
        for (int a : apple) sum += a;
        Arrays.sort(capacity);
        int n = capacity.length, ans = 0;
        for (int i = n - 1; i >= 0 && sum > 0; i--, ans++) sum -= capacity[i];
        return ans;
    }
}

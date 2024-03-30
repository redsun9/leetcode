package leetcode.leetcode28xx.leetcode2869;

import java.util.List;

public class Solution {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] seen = new boolean[k];
        int left = k, n = nums.size();
        for (int i = n - 1; i >= 0; i--) {
            int a = nums.get(i);
            if (a <= k && !seen[a - 1]) {
                seen[a - 1] = true;
                left--;
                if (left == 0) return n - i;
            }
        }
        return -1;
    }
}

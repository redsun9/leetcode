package leetcode.leetcode20xx.leetcode2006;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] count = new int[101];
        for (int num : nums) count[num]++;
        int ans = 0;
        for (int i = 0, j = k; j <= 100; i++, j++) ans += count[i] * count[j];
        return ans;
    }
}

package leetcode.leetcode16xx.leetcode1608;

public class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] count = new int[n + 1];
        for (int num : nums) count[Math.min(n, num)]++;
        for (int i = n, tmp = 0; i > 0; i--) {
            tmp += count[i];
            if (tmp == i) return i;
        }
        return -1;
    }
}

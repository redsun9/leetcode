package leetcode.leetcode19xx.leetcode1909;

public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        boolean usedDeletion = false;
        int prev = 0, curr1 = nums[0], curr2 = nums[1], next = nums[2];
        for (int i = 2; i <= n; i++) {
            if (curr1 >= curr2) {
                if (usedDeletion) return false;
                usedDeletion = true;
                if (curr1 >= next && prev >= curr2) return false;
                if (curr2 > prev) {
                    // delete curr1
                    curr1 = curr2;
                }
            } else {
                prev = curr1;
                curr1 = curr2;
            }
            curr2 = next;
            next = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
        }
        return true;
    }
}

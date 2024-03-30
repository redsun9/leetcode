package leetcode.leetcode28xx.leetcode2855;

import java.util.List;

public class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        if (n <= 1) return 0;
        int i = 1;
        while (i < n && nums.get(i - 1) <= nums.get(i)) i++;
        if (i == n) return 0;

        int j1 = i, j2 = (i + 1) % n;
        while (j2 != i) {
            if (nums.get(j1) > nums.get(j2)) return -1;
            j1 = j2;
            j2 = (j2 + 1) % n;
        }
        return n - i;
    }
}

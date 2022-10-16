package leetcode.leetcode24xx.leetcode2441;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findMaxK(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                if (ans < num && set.contains(-num)) ans = num;
            } else {
                if (ans < -num && set.contains(-num)) ans = -num;
            }
            set.add(num);
        }
        return ans == 0 ? -1 : ans;
    }
}

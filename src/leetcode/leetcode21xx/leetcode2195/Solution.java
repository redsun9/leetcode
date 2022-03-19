package leetcode.leetcode21xx.leetcode2195;

import java.util.Arrays;

public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int currentNumToFind = 1;
        for (int num : nums) {
            if (num > currentNumToFind) {
                int took = Math.min(num - currentNumToFind, k);
                ans += took * (2L * currentNumToFind + took - 1L) / 2;
                k -= took;
                if (ans == 0) return ans;
                currentNumToFind += took;
            }
            if (num == currentNumToFind) currentNumToFind++;
        }
        if (k != 0) ans += k * (2L * currentNumToFind + k - 1L) / 2;
        return ans;
    }
}

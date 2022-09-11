package leetcode.leetcode24xx.leetcode2404;

import java.util.HashMap;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxCount = 0, max = -1;
        for (int num : nums) {
            if ((num & 1) == 1) continue;
            int tmp = count.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if (tmp > maxCount || tmp == maxCount && num < max) {
                max = num;
                maxCount = tmp;
            }
        }
        return max;
    }
}

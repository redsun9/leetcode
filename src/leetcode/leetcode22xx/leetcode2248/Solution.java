package leetcode.leetcode22xx.leetcode2248;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX_VAL = 1000;

    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[MAX_VAL + 1];
        for (int[] num : nums) {
            for (int n : num) {
                count[n]++;
            }
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == n) {
                res.add(i);
            }
        }
        return res;
    }
}

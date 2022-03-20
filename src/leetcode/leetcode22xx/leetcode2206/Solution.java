package leetcode.leetcode22xx.leetcode2206;

import java.util.HashMap;

public class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        for (Integer value : map.values()) if ((value & 1) != 0) return false;
        return true;
    }
}

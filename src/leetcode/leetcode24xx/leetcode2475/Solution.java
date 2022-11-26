package leetcode.leetcode24xx.leetcode2475;

import java.util.HashMap;

public class Solution {
    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        int n = nums.length;
        int ans = n * (n - 1) * (n - 2) / 6;
        for (Integer a : map.values()) {
            ans -= a * (a - 1) / 2 * (n - a); //aa+b
            ans -= a * (a - 1) * (a - 2) / 6; //aaa
        }
        return ans;
    }
}

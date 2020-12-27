package leetcode.leetcode16xx.leetcode1679;

import java.util.HashMap;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(k - num, 0);
            if (count > 0) {
                ans++;
                if (count == 1) map.remove(k - num);
                else map.put(k - num, count - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }
}

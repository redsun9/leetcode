package leetcode.leetcode5xx.leetcode594;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            Integer val = counts.get(entry.getKey() + 1);
            if (val != null) ans = Math.max(ans, entry.getValue() + val);
        }
        return ans;
    }
}

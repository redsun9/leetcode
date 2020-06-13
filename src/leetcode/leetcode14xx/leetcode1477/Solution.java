package leetcode.leetcode14xx.leetcode1477;

import java.util.HashMap;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] left = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        left[0] = Integer.MAX_VALUE;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            left[i + 1] = left[i];
            if (map.containsKey(sum - target)) {
                int prevPos = map.get(sum - target);
                int tmpValue = i - prevPos;
                if (left[prevPos + 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, tmpValue + left[prevPos + 1]);
                }
                left[i + 1] = Math.min(left[i], tmpValue);
            }
            map.put(sum, i);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}

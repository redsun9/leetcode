package leetcode.leetcode2xx.leetcode220;

import java.util.HashMap;
import java.util.Map;

// O(N)
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n <= 1 || t < 0 || k <= 0) return false;

        long bucketLength = (long) t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0, j = -k - 1; i < n; i++, j++) {
            if (j >= 0) map.remove(((long) nums[j] - Integer.MIN_VALUE) / bucketLength);
            long val = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = val / bucketLength;
            if (
                    map.containsKey(bucket)
                            || map.containsKey(bucket - 1) && val - map.get(bucket - 1) <= t
                            || map.containsKey(bucket + 1) && map.get(bucket + 1) - val <= t
            ) return true;
            map.put(bucket, val);
        }
        return false;
    }
}

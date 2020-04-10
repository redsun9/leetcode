package leetcode.leetcode4xx.leetcode410;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int) sum;
        if (m == nums.length) return max;
        long lo = max;
        long hi = sum;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            int count = 1;
            long subSum = 0;
            for (int num : nums) {
                subSum += num;
                if (subSum > mid) {
                    subSum = num;
                    count++;
                    if (count > m) break;
                }
            }
            if (count <= m) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) hi + 1;
    }
}

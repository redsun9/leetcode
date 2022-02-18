package leetcode.leetcode21xx.leetcode2163;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] left = new long[n + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long currSum = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            currSum += nums[i];
        }
        left[0] = currSum;
        for (int i1 = 0, i2 = n; i1 < n; i1++, i2++) {
            pq.offer(nums[i2]);
            currSum += nums[i2];
            currSum -= pq.poll();
            left[i1 + 1] = Math.min(left[i1], currSum);
        }

        currSum = 0;
        pq = new PriorityQueue<>();
        for (int i1 = 0, i2 = 3 * n - 1; i1 < n; i1++, i2--) {
            pq.offer(nums[i2]);
            currSum += nums[i2];
        }

        long ans = left[n] - currSum;
        for (int i1 = n - 1, i2 = 2 * n - 1; i1 >= 0; i1--, i2--) {
            pq.offer(nums[i2]);
            currSum += nums[i2];
            currSum -= pq.poll();
            ans = Math.min(ans, left[i1] - currSum);
        }
        return ans;
    }
}

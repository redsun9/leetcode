package leetcode.leetcode23xx.leetcode2333;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1 + k2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) pq.offer(Math.abs(nums1[i] - nums2[i]));
        pq.offer(0);
        int pollCount = 0, pollValue = pq.peek();
        long ans = 0;
        while (!pq.isEmpty()) {
            int peek = pq.peek();
            int toEqualize = (pollValue - peek) * pollCount;
            if (toEqualize <= k) {
                k -= toEqualize;
                pollCount++;
                pq.poll();
                pollValue = peek;
            } else {
                long div = k / pollCount, mod = k % pollCount;
                ans += mod * (pollValue - div - 1) * (pollValue - div - 1) + (pollCount - mod) * (pollValue - div) * (pollValue - div);
                k = 0;
                break;
            }
        }

        while (!pq.isEmpty()) {
            long poll = pq.poll();
            ans += poll * poll;
        }
        return ans;
    }
}

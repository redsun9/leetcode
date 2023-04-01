package leetcode.leetcode25xx.leetcode2542;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // [num1, num2]
        PriorityQueue<int[]> pqAvailable = new PriorityQueue<>(Comparator.comparingInt(x -> -x[1]));
        PriorityQueue<Integer> pqUsed = new PriorityQueue<>();
        long ans = 0, sumUsed = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) pqAvailable.offer(new int[]{nums1[i], nums2[i]});
        while (!pqAvailable.isEmpty()) {
            int threshold = pqAvailable.peek()[1];
            while (!pqAvailable.isEmpty() && pqAvailable.peek()[1] >= threshold) {
                int[] poll = pqAvailable.poll();
                pqUsed.offer(poll[0]);
                sumUsed += poll[0];
            }
            while (pqUsed.size() > k) sumUsed -= pqUsed.poll();
            if (pqUsed.size() == k) ans = Math.max(ans, sumUsed * threshold);
        }
        return ans;
    }
}

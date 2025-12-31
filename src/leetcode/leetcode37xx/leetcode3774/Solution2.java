package leetcode.leetcode37xx.leetcode3774;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    @SuppressWarnings("DataFlowIssue")
    public int absDifference(int[] nums, int k) {
        k = Math.min(k, nums.length - k);
        if (k == 0) return 0;
        PriorityQueue<Integer> pqLow = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqHigh = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            pqLow.offer(num);
            pqHigh.offer(num);
            if (i >= k) {
                pqLow.poll();
                pqHigh.poll();
            }
        }
        int tmp = 0;
        for (int i = 0; i < k; i++) tmp += pqHigh.poll() - pqLow.poll();
        return tmp;
    }
}

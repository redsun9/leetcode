package leetcode.leetcode32xx.leetcode3266;

import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    private static final int p = 1_000_000_007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (k == 0 || multiplier == 1) return nums;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) maxVal = Math.max(maxVal, num);
        int threshold = maxVal / multiplier + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (nums[a] != nums[b]) return nums[a] - nums[b];
            else return a - b;
        });
        for (int i = 0; i < nums.length; i++) pq.offer(i);

        while (k > 0 && nums[pq.peek()] < threshold) {
            k--;
            int poll = pq.poll();
            nums[poll] *= multiplier;
            pq.offer(poll);
        }

        int full = k / nums.length, remainder = k % nums.length;
        while (remainder != 0) {
            remainder--;
            int poll = pq.poll();
            nums[poll] = (int) ((long) nums[poll] * multiplier % p);
        }

        if (full != 0) {
            long powMod = powMod(multiplier, full);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (nums[i] * powMod % p);
            }
        }
        return nums;
    }

    private static int powMod(int a, int b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % p;
                --b;
            } else {
                a = (int) (((long) a * a) % p);
                b >>= 1;
            }
        return (int) res;
    }
}

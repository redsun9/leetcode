package leetcode.leetcode10xx.leetcode1005;

import java.util.PriorityQueue;

public class Solution {
    @SuppressWarnings("ConstantConditions")
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int negNum = 0, negSum = 0, posSum = 0;
        boolean hasZero = false;
        for (int num : nums) {
            if (num == 0) hasZero = true;
            else {
                pq.offer(num);
                if (num < 0) {
                    negNum++;
                    negSum += num;
                } else posSum += num;
            }
        }
        if (negNum <= k && (hasZero || (negNum + k) % 2 == 0)) return posSum - negSum;
        int ans = posSum + negSum;
        while (k > 0 && pq.peek() < 0) {
            int poll = -pq.poll();
            ans = ans + 2 * poll;
            pq.offer(poll);
            k--;
        }
        if (k != 0) ans -= 2 * pq.peek();
        return ans;
    }
}

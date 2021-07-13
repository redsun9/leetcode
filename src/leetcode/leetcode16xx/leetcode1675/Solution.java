package leetcode.leetcode16xx.leetcode1675;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if ((num & 1) == 1) num <<= 1;
            pq.offer(num);
            min = Math.min(min, num);
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            Integer poll = pq.poll();
            ans = Math.min(ans, poll - min);
            if ((poll & 1) == 1) return ans;
            poll >>>= 1;
            min = Math.min(min, poll);
            pq.offer(poll);
        }
    }
}

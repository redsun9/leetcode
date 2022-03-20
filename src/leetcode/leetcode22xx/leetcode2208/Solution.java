package leetcode.leetcode22xx.leetcode2208;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int num : nums) sum += num;
        long multiplier = Long.highestOneBit(Long.MAX_VALUE / sum);
        sum *= multiplier;
        for (long num : nums) pq.offer(num * multiplier);
        long target = sum >> 1;
        int ans = 0;
        while (sum > target) {
            long a = pq.poll() >> 1;
            sum -= a;
            pq.offer(a);
            ans++;
        }
        return ans;
    }
}

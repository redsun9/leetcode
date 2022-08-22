package leetcode.leetcode23xx.leetcode2386;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length, numZero = 0;
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) numZero++;
            else if (nums[i] > 0) maxSum += nums[i];
            else nums[i] = -nums[i];
        }
        k = (k - 1) >> numZero;
        if (k == 0) return maxSum;
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> -x.sum));
        pq.offer(new Pair(maxSum - nums[numZero], numZero));
        while (--k != 0) {
            Pair poll = pq.poll();
            if (poll.idx + 1 < n) {
                pq.offer(new Pair(poll.sum + nums[poll.idx] - nums[poll.idx + 1], poll.idx + 1));
                pq.offer(new Pair(poll.sum - nums[poll.idx + 1], poll.idx + 1));
            }
        }
        return pq.poll().sum;
    }

    private record Pair(long sum, int idx) {
    }
}

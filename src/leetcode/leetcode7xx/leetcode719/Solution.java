package leetcode.leetcode7xx.leetcode719;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//TLE on k = 25_000_000
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        for (int i = 1; i < n; i++) pq.add(new int[]{i - 1, i, nums[i] - nums[i - 1]});
        while (true) {
            int[] poll = pq.poll();
            if (--k == 0) return poll[2];
            if (++poll[1] < n) {
                poll[2] = nums[poll[1]] - nums[poll[0]];
                pq.offer(poll);
            }
        }
    }
}

package leetcode.leetcode6xx.leetcode632;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        if (n == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            int val = nums.get(i).get(0);
            pq.add(new int[]{val, i, 0});
            left = Math.min(left, val);
            right = Math.max(right, val);
        }
        int length = right - left, curRight = right;
        while (true) {
            int[] poll = pq.poll();
            poll[2]++;
            if (nums.get(poll[1]).size() == poll[2]) break;
            int newVal = nums.get(poll[1]).get(poll[2]);
            poll[0] = newVal;
            pq.offer(poll);
            curRight = Math.max(curRight, newVal);
            if (curRight - pq.peek()[0] < length) {
                left = pq.peek()[0];
                right = curRight;
                length = right - left;
            }
        }
        return new int[]{left, right};
    }
}

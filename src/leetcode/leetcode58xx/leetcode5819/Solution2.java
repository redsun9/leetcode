package leetcode.leetcode58xx.leetcode5819;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class Solution2 {
    public int[] findMaximums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
        for (int i = 0; i < n; i++) pq.offer(new int[]{nums[i], i});
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int[] pair = pq.poll();
            Integer floor = set.floor(pair[1]);
            if (floor == null) floor = -1;
            Integer ceiling = set.ceiling(pair[1]);
            if (ceiling == null) ceiling = n;
            ans[ceiling - floor - 2] = pair[0];
            set.add(pair[1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }
}

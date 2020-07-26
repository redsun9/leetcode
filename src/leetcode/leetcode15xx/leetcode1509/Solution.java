package leetcode.leetcode15xx.leetcode1509;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            min.offer(num);
            max.offer(num);
            if (i >= 4) {
                min.poll();
                max.poll();
            }
        }
        ArrayList<Integer> minList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            minList.add(min.poll());
            maxList.add(max.poll());
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, Math.abs(maxList.get(i) - minList.get(3 - i)));
        }
        return ans;
    }
}

package leetcode.leetcode12xx.leetcode1208;

import java.util.LinkedList;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int ans = 0;
        int curSum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            queue.addFirst(diff);
            curSum += diff;
            while (curSum > maxCost && !queue.isEmpty()) curSum -= queue.pollLast();
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }
}

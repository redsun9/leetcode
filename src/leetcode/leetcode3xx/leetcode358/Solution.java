package leetcode.leetcode3xx.leetcode358;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return a string such that the same characters are at least distance k from each other
     */
    public String rearrangeString(String s, int k) {
        if (k == 1) return s;
        int n = s.length();
        char[] ans = s.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>(26, Comparator.comparingInt(x -> -x[1]));
        Queue<int[]> wq = new ArrayDeque<>(26);
        for (int i = 0; i < 26; i++) if (cnt[i] != 0) pq.add(new int[]{i, cnt[i], 0});

        for (int i = 0; i < n; i++) {
            if (!wq.isEmpty() && wq.peek()[2] == i) pq.offer(wq.poll());
            if (pq.isEmpty()) return "";
            int[] poll = pq.poll();
            ans[i] = (char) ('a' + poll[0]);
            if (--poll[1] == 0) continue;
            poll[2] = i + k;
            wq.offer(poll);
        }
        return new String(ans);
    }
}

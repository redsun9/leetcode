package leetcode.leetcode14xx.leetcode1456;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maxVowels(String s, int k) {
        Queue<Integer> queue = new ArrayDeque<>(k);
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                while (!queue.isEmpty() && queue.peek() >= i + k) queue.poll();
                queue.add(i);
                ans = Math.max(ans, queue.size());
            }
        }
        return ans;
    }
}

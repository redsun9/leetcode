package leetcode.leetcode18xx.leetcode1871;

import java.util.ArrayDeque;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int n = s.length();
        for (int i = 1, j1 = -maxJump, j2 = 1 - minJump; i < n; i++, j1++, j2++) {
            if (s.charAt(i) != '0') continue;
            while (!queue.isEmpty() && queue.peekFirst() <= j1) queue.pollFirst();
            if (queue.isEmpty()) return false;
            else if (queue.peekFirst() <= j2) queue.addLast(i);
        }
        return !queue.isEmpty() && queue.peekLast() == n - 1;
    }
}

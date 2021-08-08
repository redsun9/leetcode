package leetcode.leetcode10xx.leetcode1003;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 3 != 0) return false;
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (queue.isEmpty() || queue.pollLast() != 'b') return false;
                if (queue.isEmpty() || queue.pollLast() != 'a') return false;
            } else queue.addLast(c);
        }
        return queue.isEmpty();
    }
}

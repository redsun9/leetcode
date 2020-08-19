package leetcode.leetcode9xx.leetcode995;

import java.util.ArrayDeque;

public class Solution {
    public int minKBitFlips(int[] a, int k) {
        ArrayDeque<Integer> flips = new ArrayDeque<>(k);
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!flips.isEmpty() && flips.peek() == i) flips.poll();
            if (((a[i] ^ flips.size()) & 1) == 0) {
                flips.addLast(i + k);
                ans++;
            }
        }
        if (!flips.isEmpty() && flips.peekFirst() == n) flips.pop();
        return flips.isEmpty() ? ans : -1;
    }
}

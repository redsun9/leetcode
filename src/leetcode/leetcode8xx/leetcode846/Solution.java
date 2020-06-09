package leetcode.leetcode8xx.leetcode846;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 1) return true;
        if (n % k != 0) return false;
        Arrays.sort(nums);
        ArrayDeque<Pair> deque = new ArrayDeque<>(k);
        int i = 0;
        int waitingTotal = 0;
        int prev = 0;

        while (i < n) {
            int curr = nums[i];
            int cnt = 0;
            while (i < n && nums[i] == curr) {
                i++;
                cnt++;
            }
            if (curr != prev + 1) {
                if (waitingTotal != 0) return false;
                deque.addLast(new Pair(curr, cnt));
            } else {
                if (cnt < waitingTotal) return false;
                if (!deque.isEmpty() && deque.peekFirst().val == curr - k + 1) {
                    Pair pair = deque.pollFirst();
                    waitingTotal -= pair.cnt;
                    cnt -= pair.cnt;
                }
                if (waitingTotal < cnt) {
                    deque.addLast(new Pair(curr, cnt - waitingTotal));
                }
            }
            waitingTotal = cnt;
            prev = curr;
        }
        return waitingTotal == 0;
    }

    private static class Pair {
        private final int val;
        private final int cnt;

        public Pair(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}

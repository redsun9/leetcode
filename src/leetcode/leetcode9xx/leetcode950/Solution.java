package leetcode.leetcode9xx.leetcode950;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Queue<Integer> queue = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) queue.add(i);
        int[] ans = new int[n];
        for (int i = 0; i < n - 1; i++) {
            ans[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        ans[queue.poll()] = deck[n - 1];
        return ans;
    }
}

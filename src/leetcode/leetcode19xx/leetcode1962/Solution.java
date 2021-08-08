package leetcode.leetcode19xx.leetcode1962;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0;
        for (int pile : piles) {
            pq.offer(pile);
            ans += pile;
        }
        while (k-- > 0 && ans != 0) {
            Integer poll = pq.poll();
            ans -= poll / 2;
            pq.offer((poll + 1) / 2);
        }
        return ans;
    }
}

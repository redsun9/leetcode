package leetcode.leetcode37xx.leetcode3771;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        long ans = 0;
        PriorityQueue<Integer> rewards = new PriorityQueue<>(Comparator.reverseOrder());
        int totalDamage = 0;
        for (int i = damage.length - 1; i >= 0; i--) {
            rewards.offer(requirement[i] - totalDamage);
            totalDamage += damage[i];
            while (!rewards.isEmpty() && hp - totalDamage < rewards.peek()) rewards.poll();
            ans += rewards.size();
        }
        return ans;
    }
}

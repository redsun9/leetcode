package leetcode.leetcode16xx.leetcode1642;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int maxIndex = heights.length - 1;
        int ans = 0;
        while (ans < maxIndex) {
            int diff = heights[ans + 1] - heights[ans];
            if (diff > 0) {
                pq.offer(diff);
                bricks -= diff;
                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += pq.poll();
                        ladders--;
                    } else return ans;
                }
            }
            ans++;
        }
        return ans;
    }
}

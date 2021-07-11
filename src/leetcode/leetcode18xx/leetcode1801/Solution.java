package leetcode.leetcode18xx.leetcode1801;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static final int p = 1_000_000_007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>(Comparator.comparingInt(x -> -x[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (order[1] != 0 && !sell.isEmpty() && sell.peek()[0] <= order[0]) {
                    int a = Math.min(order[1], sell.peek()[1]);
                    order[1] -= a;
                    sell.peek()[1] -= a;
                    if (sell.peek()[1] == 0) sell.poll();
                }
                if (order[1] != 0) buy.offer(order);
            } else {
                while (order[1] != 0 && !buy.isEmpty() && buy.peek()[0] >= order[0]) {
                    int a = Math.min(order[1], buy.peek()[1]);
                    order[1] -= a;
                    buy.peek()[1] -= a;
                    if (buy.peek()[1] == 0) buy.poll();
                }
                if (order[1] != 0) sell.offer(order);
            }
        }
        int ans = 0;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
            if (ans >= p) ans -= p;
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}

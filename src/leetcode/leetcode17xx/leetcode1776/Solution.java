package leetcode.leetcode17xx.leetcode1776;

import java.util.ArrayDeque;

public class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        ans[n - 1] = Double.MAX_VALUE;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int posStart = cars[i][0], velocity = cars[i][1];
            double t = Double.MAX_VALUE;
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (velocity <= cars[peek][1]) stack.pop();
                else {
                    t = ((double) cars[peek][0] - posStart) / (velocity - cars[peek][1]);
                    if (t >= ans[peek]) stack.pop();
                    else break;
                }
            }
            ans[i] = t;
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Double.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}

package leetcode.leetcode13xx.leetcode1376;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        int[] time = new int[n];
        Arrays.fill(time, -1);
        time[headId] = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (time[i] >= 0) continue;
            if (time[manager[i]] < 0) {
                stack.push(manager[i]);
                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if (time[manager[peek]] >= 0) {
                        time[peek] = time[manager[peek]] + informTime[manager[peek]];
                        stack.pop();
                    } else stack.push(manager[peek]);
                }
            }
            time[i] = time[manager[i]] + informTime[manager[i]];
        }
        int ans = 0;
        for (int t : time) ans = Math.max(ans, t);
        return ans;
    }
}

package leetcode.leetcode23xx.leetcode2360;

public class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length, ans = -1;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int counter = 1, node = i;
            while (node != -1 && time[node] == 0) {
                time[node] = counter++;
                node = edges[node];
            }
            if (node != -1 && time[node] != -1) ans = Math.max(ans, counter - time[node]);
            node = i;
            while (node != -1 && time[node] != -1) {
                time[node] = -1;
                node = edges[node];
            }
        }
        return ans;
    }
}

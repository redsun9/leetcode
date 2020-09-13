package leetcode.leetcode15xx.leetcode1583;

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] friends = new int[n];
        int[][] orders = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] preference = preferences[i];
            int[] order = orders[i];
            for (int j = 0; j < n - 1; j++) order[preference[j]] = j;
            order[i] = n;
        }
        for (int[] pair : pairs) {
            friends[pair[0]] = pair[1];
            friends[pair[1]] = pair[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = friends[x];
            int[] order = orders[x];
            int orderY = order[y];
            for (int u = 0; u < n; u++) {
                if (order[u] < orderY && orders[u][x] < orders[u][friends[u]]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}

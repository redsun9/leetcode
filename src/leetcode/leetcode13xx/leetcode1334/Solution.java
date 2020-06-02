package leetcode.leetcode13xx.leetcode1334;

import java.util.Arrays;

public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(w[i], distanceThreshold + 1);
            w[i][i] = 0;
        }
        for (int[] edge : edges) {
            w[edge[0]][edge[1]] = edge[2];
            w[edge[1]][edge[0]] = edge[2];
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i == j || w[i][j] > distanceThreshold) continue;
                for (int k = 0; k < n; k++) {
                    if (i != k && j != k && w[i][k] > w[i][j] + w[j][k]) {
                        w[i][k] = w[i][j] + w[j][k];
                    }
                }
            }
        }
        int ans = 0;
        int min = n;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (w[i][j] <= distanceThreshold) tmp++;
            }
            if (tmp < min) {
                if (tmp == 1) return i;
                ans = i;
                min = tmp;
            }
        }
        return ans;
    }
}

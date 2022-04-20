package leetcode.leetcode7xx.leetcode765;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0, n = row.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[row[i]] = i;

        for (int i = 0; i < n; i += 2) {
            int ptn = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if (row[i + 1] == ptn) continue;

            int ptnPos = pos[ptn];
            row[ptnPos] = row[i + 1];
            pos[row[i + 1]] = ptnPos;
            ans++;
        }
        return ans;
    }
}

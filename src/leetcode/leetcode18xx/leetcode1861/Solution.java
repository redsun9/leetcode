package leetcode.leetcode18xx.leetcode1861;

public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i1 = 0, j2 = m - 1; i1 < m; i1++, j2--) {
            for (int j1 = 0, i2 = 0; j1 < n; j1++, i2++) {
                ans[i2][j2] = box[i1][j1];
            }
        }
        for (int j = 0; j < m; j++) {
            int pos = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (ans[i][j] == '#') {
                    char tmp = ans[pos][j];
                    ans[pos--][j] = '#';
                    ans[i][j] = tmp;
                } else if (ans[i][j] == '*') pos = i - 1;
            }
        }
        return ans;
    }
}

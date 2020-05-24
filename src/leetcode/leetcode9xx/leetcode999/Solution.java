package leetcode.leetcode9xx.leetcode999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int ans = 0;
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != '.') {
                            ans += board[k][j] == 'p' ? 1 : 0;
                            break;
                        }
                    }
                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] != '.') {
                            ans += board[k][j] == 'p' ? 1 : 0;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] != '.') {
                            ans += board[i][k] == 'p' ? 1 : 0;
                            break;
                        }
                    }
                    for (int k = j + 1; k < 8; k++) {
                        if (board[i][k] != '.') {
                            ans += board[i][k] == 'p' ? 1 : 0;
                            break;
                        }
                    }
                    return ans;
                }
            }
        }
        return 0;
    }
}

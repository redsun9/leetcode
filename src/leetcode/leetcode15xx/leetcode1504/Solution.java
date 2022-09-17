package leetcode.leetcode15xx.leetcode1504;

// O(m*n) - time
// O(min(m,n)) - space
public class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] prev, curr;
        for (int i = 1; i < m; i++) {
            prev = mat[i - 1];
            curr = mat[i];
            for (int j = 0; j < n; j++) if (curr[j] != 0) curr[j] += prev[j];
        }
        int ans = 0;

        int[] queueH = new int[n];
        int[] queueW = new int[n];
        int queueSize, sum;

        for (int[] row : mat) {
            queueSize = 0;
            sum = 0;
            for (int h : row) {
                int curW = 1;
                while (queueSize != 0 && queueH[queueSize - 1] >= h) {
                    queueSize--;
                    sum -= queueH[queueSize] * queueW[queueSize];
                    curW += queueW[queueSize];
                }
                queueH[queueSize] = h;
                queueW[queueSize++] = curW;
                sum += h * curW;
                ans += sum;
            }
        }
        return ans;
    }
}

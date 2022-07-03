package leetcode.leetcode23xx.leetcode2326;

import leetcode.tools.ListNode;

import java.util.Arrays;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for (int[] row : mat) Arrays.fill(row, -1);
        int l = 0, r = n - 1, u = 0, d = m - 1, i, j;
        while (l <= r && u <= d && head != null) {
            i = u++;
            j = l;
            while (head != null && j <= r) {
                mat[i][j++] = head.val;
                head = head.next;
            }

            if (u > d || head == null) break;
            i = u;
            j = r--;
            while (head != null && i <= d) {
                mat[i++][j] = head.val;
                head = head.next;
            }

            if (l > r || head == null) break;
            i = d--;
            j = r;
            while (head != null && j >= l) {
                mat[i][j--] = head.val;
                head = head.next;
            }

            if (u > d || head == null) break;
            i = d;
            j = l++;
            while (head != null && i >= u) {
                mat[i--][j] = head.val;
                head = head.next;
            }
        }
        return mat;
    }
}

package leetcode.leetcode3xx.leetcode321;

import java.util.Stack;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
            int[] can = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (larger(can, 0, res, 0)) {
                res = can;
            }
        }
        return res;
    }

    private int[] maxArray(int[] num, int k) {
        if (k == 0) return new int[0];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < num.length; ++i) {
            int cur = num[i];
            while (!stk.isEmpty() && stk.peek() < cur && stk.size() + num.length - 1 - i >= k) {
                stk.pop();
            }
            if (stk.size() < k) {
                stk.push(cur);
            }
        }
        int[] rst = new int[k];
        for (int i = 0; i < k; ++i) {
            rst[k - i - 1] = stk.pop();
        }
        return rst;
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int valid = 0, i = 0, j = 0;
        while (i < a.length && j < b.length) {
            res[valid++] = larger(a, i, b, j) ? a[i++] : b[j++];
        }
        while (i < a.length) {
            res[valid++] = a[i++];
        }
        while (j < b.length) {
            res[valid++] = b[j++];
        }
        return res;
    }

    private boolean larger(int[] a, int x, int[] b, int y) {
        while (x < a.length && y < b.length && a[x] == b[y]) {
            x++;
            y++;
        }
        return y == b.length || (x < a.length && a[x] > b[y]);
    }
}

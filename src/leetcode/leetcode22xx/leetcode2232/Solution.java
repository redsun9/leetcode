package leetcode.leetcode22xx.leetcode2232;

public class Solution {
    public static final int[] tens = {
            1, 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000
    };

    public String minimizeResult(String expression) {
        char[] arr = expression.toCharArray();
        int left = 0, right = 0, mid = 0, n = arr.length;
        for (char c : arr) {
            if (c == '+') break;
            left = left * 10 + c - '0';
            mid++;
        }

        for (int i = mid + 1; i < n; i++) right = right * 10 + arr[i] - '0';

        int min = left + right, minLeft = 0, minRight = n;

        for (int i = 0; i < mid; i++) {
            int a = left / tens[mid - i], b = left % tens[mid - i];
            for (int j = mid + 2; j <= n; j++) {
                int c = right / tens[n - j], d = right % tens[n - j];
                int tmp = b + c;
                if (i != 0) tmp *= a;
                if (j != n) tmp *= d;
                if (min > tmp) {
                    min = tmp;
                    minLeft = i;
                    minRight = j;
                }
            }
        }
        return expression.substring(0, minLeft) + "(" + expression.substring(minLeft, mid) + "+" +
                expression.substring(mid + 1, minRight) + ")" + expression.substring(minRight, n);
    }
}

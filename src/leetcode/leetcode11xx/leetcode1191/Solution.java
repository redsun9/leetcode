package leetcode.leetcode11xx.leetcode1191;

public class Solution {
    public static final int p = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        if (k == 1) return maxMiddleSum(arr);
        long maxLeftSum = maxLeftSum(arr);
        long maxRightSum = maxRightSum(arr);
        long maxMiddleSum = maxMiddleSum(arr);
        long sum = Math.max(0, sum(arr));
        return (int) (max(maxMiddleSum, maxLeftSum + (k - 2) * sum + maxRightSum) % p);
    }

    private static long max(long... a) {
        long ans = a[0];
        for (long i : a) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    private static int maxLeftSum(int[] arr) {
        int ans = 0;
        int curr = 0;
        for (int a : arr) {
            curr += a;
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    private static int maxRightSum(int[] arr) {
        int ans = 0;
        int curr = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            curr += arr[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    private static int maxMiddleSum(int[] arr) {
        int ans = 0;
        int curr = 0;
        for (int a : arr) {
            if (a > 0) {
                curr += a;
                ans = Math.max(ans, curr);
            } else {
                curr += a;
                if (curr < 0) curr = 0;
            }
        }
        return ans;
    }

    private static int sum(int[] arr) {
        int ans = 0;
        for (int a : arr) {
            ans += a;
        }
        return ans;
    }
}

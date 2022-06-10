package suggestions.subarray_with_max_average;

public class Solution2 {
    public int[] maxAverage(int[] arr, int minL) {
        int n = arr.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) sums[i + 1] = sums[i] + arr[i];
        long maxSum = Integer.MIN_VALUE;
        int maxL = 0, maxR = 0;

        for (int l = 0, j = minL; j <= n; l++, j++) {
            for (int r = j; r <= n; r++) {
                long sum = sums[r] - sums[l];
                if (sum * (maxR - maxL) > maxSum * (r - l)) {
                    maxSum = sum;
                    maxL = l;
                    maxR = r;
                }
            }
        }
        return new int[]{maxL, maxR};
    }
}

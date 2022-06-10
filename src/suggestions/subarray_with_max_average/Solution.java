package suggestions.subarray_with_max_average;

// Search for a subarray with a length at least minL with a maximum average
// return it's average

public class Solution {
    public int[] maxAverage(int[] arr, int minL) {
        int n = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int a : arr) maxVal = Math.max(maxVal, a);
        long sum = 0;
        for (int a : arr) sum += a;

        int curLoStart = 0, curLoEnd = n;
        long curLoSum = sum;
        double hi = maxVal;
        double eps = 1.0 / n / n / 2;

        while ((hi - eps) * (curLoEnd - curLoStart) >= curLoSum) {
            double m = (hi * (curLoEnd - curLoStart) + curLoSum) / (curLoEnd - curLoStart) / 2;
            Result result = check(arr, minL, m);
            if (result.success) {
                curLoStart = result.start;
                curLoEnd = result.end;
                curLoSum = result.sum;
            } else hi = m;
        }
        return new int[]{curLoStart, curLoEnd};
    }

    private static Result check(int[] arr, int minL, double val) {
        long minLeftSum = 0, leftSum = 0;
        long rightSum = 0;
        int minLeftIndex = -1;

        int n = arr.length;
        for (int i = 0; i < minL; i++) rightSum += arr[i];
        if (rightSum >= val * minL) return new Result(true, 0, minL, rightSum);

        for (int r = minL, l = 0; r < n; r++, l++) {
            rightSum += arr[r];
            leftSum += arr[l];
            if (leftSum - minLeftSum < val * (l - minLeftIndex)) {
                minLeftSum = leftSum;
                minLeftIndex = l;
            }
            if (rightSum - minLeftSum >= val * (r - minLeftIndex))
                return new Result(true, minLeftIndex + 1, r + 1, rightSum - minLeftSum);
        }
        return new Result(false, 0, 0, 0);
    }

    private record Result(boolean success, int start, int end, long sum) {
    }
}

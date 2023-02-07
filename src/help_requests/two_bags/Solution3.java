package help_requests.two_bags;

// massive is circle
// negative values allowed
public class Solution3 {
    public static long maxSum(int[] arr) {
        long totalSum = 0;
        for (int num : arr) totalSum += num;

        long maxSum = 0, curSum = 0;
        for (int num : arr) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) curSum = 0;
        }

        long minSum = 0;
        curSum = 0;
        for (int num : arr) {
            curSum += num;
            minSum = Math.min(minSum, curSum);
            if (curSum > 0) curSum = 0;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static long dummyMaxSum(int[] arr) {
        long maxSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long curSum = 0;
            for (int j = i; j < i + n; j++) {
                int num = arr[j % n];
                curSum += num;
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }
}

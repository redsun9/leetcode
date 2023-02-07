package help_requests.two_bags;

import java.util.*;

// negative values allowed
// massive is repeated m times
// at most k different values allowed in subarray
public class Solution7 {
    public static long maxSum(int[] arr, int m, int k, boolean isCircle) {
        if (m == 1) return maxCircleSum(arr, k, isCircle, false);
        int unique = totalUnique(arr);
        if (unique <= k) {
            long totalSum = totalSum(arr);
            if (totalSum > 0) {
                long ans = Math.max(maxRightSum(arr) + (m - 2) * totalSum + maxLeftSum(arr), maxMiddleSum(arr));
                if (isCircle) ans = Math.max(ans, m * totalSum - minMiddleSum(arr));
                return ans;
            }
            return Math.max(maxRightSum(arr) + maxLeftSum(arr), maxMiddleSum(arr));
        } else return maxCircleSum(arr, k, isCircle, true);
    }

    private static long totalSum(int[] arr) {
        long totalSum = 0;
        for (int num : arr) totalSum += num;
        return totalSum;
    }

    private static int totalUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        return set.size();
    }

    private static long maxLeftSum(int[] arr) {
        long maxSum = 0;
        long curSum = 0;
        for (int num : arr) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    private static long maxRightSum(int[] arr) {
        long maxSum = 0;
        long curSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            curSum += arr[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    private static long maxMiddleSum(int[] arr) {
        long maxSum = 0;
        long curSum = 0;
        for (int num : arr) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) curSum = 0;
        }
        return maxSum;
    }

    private static long minMiddleSum(int[] arr) {
        long minSum = 0;
        long curSum = 0;
        for (int num : arr) {
            curSum += num;
            minSum = Math.min(minSum, curSum);
            if (curSum > 0) curSum = 0;
        }
        return minSum;
    }

    private static long maxCircleSum(int[] arr, int k, boolean isCircle, boolean mGreaterThanOne) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, curSum = 0, leftSum = 0;
        int left = 0, n = arr.length;
        Deque<Pair> deque = new ArrayDeque<>();
        int maxRightVirtualIndex = isCircle || mGreaterThanOne ? n * 2 : n;
        for (int right = 0; right < maxRightVirtualIndex; right++) {
            int num = arr[right % n];
            curSum += num;
            if (num < 0) {
                while (!deque.isEmpty() && deque.peekLast().sum >= curSum) deque.removeLast();
                deque.addLast(new Pair(right, curSum));
            }
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);

            while (map.size() > k || !mGreaterThanOne && right - left + 1 > n) {
                int leftNum = arr[left++ % n];
                map.compute(leftNum, (key, value) -> value == 1 ? null : value - 1);
                leftSum += leftNum;
            }
            while (!deque.isEmpty() && deque.peekFirst().index < left) deque.removeFirst();

            if (!deque.isEmpty() && deque.peekFirst().sum < leftSum) {
                Pair target = deque.removeFirst();
                while (left <= target.index)
                    map.compute(arr[left++ % n], (key, value) -> value == 1 ? null : value - 1);
                leftSum = target.sum;
            }
            maxSum = Math.max(maxSum, curSum - leftSum);
        }
        return maxSum;
    }

    public static long dummyMaxSum(int[] arr, int m, int k, boolean isCircle) {
        if (m == 1) {
            if (isCircle) return Solution5.maxSum(arr, k);
            else return Solution.maxSum(arr, k);
        }
        int unique = totalUnique(arr);
        if (unique <= k) {
            long totalSum = totalSum(arr);
            if (totalSum > 0) {
                long ans = Math.max(maxRightSum(arr) + (m - 2) * totalSum + maxLeftSum(arr), maxMiddleSum(arr));
                if (isCircle) ans = Math.max(ans, m * totalSum - minMiddleSum(arr));
                return ans;
            }
            return Math.max(maxRightSum(arr) + maxLeftSum(arr), maxMiddleSum(arr));
        }
        long maxSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long curSum = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + n; j++) {
                int num = arr[j % n];
                if (set.size() < k || set.contains(num)) {
                    set.add(num);
                    curSum += num;
                    maxSum = Math.max(maxSum, curSum);
                } else break;
            }
        }
        return maxSum;
    }

    private record Pair(int index, long sum) {
    }
}

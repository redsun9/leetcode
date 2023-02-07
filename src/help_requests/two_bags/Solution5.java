package help_requests.two_bags;

import java.util.*;
import java.util.function.BiFunction;

// negative values allowed
// massive is circle
// at most k different values allowed in subarray
public class Solution5 {

    private static final BiFunction<Integer, Integer, Integer> increment = (key, value) -> value == null ? 1 : value + 1;
    private static final BiFunction<Integer, Integer, Integer> decrement = (key, value) -> value == 1 ? null : value - 1;

    public static long maxSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, curSum = 0, leftSum = 0;
        int left = 0, n = arr.length;
        Deque<Pair> deque = new ArrayDeque<>();
        for (int right = 0; right < n * 2; right++) {
            int num = arr[right % n];
            curSum += num;
            map.compute(num, increment);

            while (map.size() > k || right - left + 1 > n) {
                int leftNum = arr[left++ % n];
                map.compute(leftNum, decrement);
                leftSum += leftNum;
            }

            if (num < 0) {
                while (!deque.isEmpty() && deque.peekLast().sum >= curSum) deque.removeLast();
                deque.addLast(new Pair(right, curSum));
            }

            while (!deque.isEmpty() && deque.peekFirst().index < left) deque.removeFirst();

            if (!deque.isEmpty() && deque.peekFirst().sum < leftSum) {
                Pair pair = deque.removeFirst();
                while (left <= pair.index) map.compute(arr[left++], decrement);
                leftSum = pair.sum;
            }
            maxSum = Math.max(maxSum, curSum - leftSum);
        }
        return maxSum;
    }

    public static long dummyMaxSum(int[] arr, int k) {
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

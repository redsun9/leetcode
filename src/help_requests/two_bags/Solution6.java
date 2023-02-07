package help_requests.two_bags;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// only positive values
// massive is repeated m times
// at most k different values allowed in subarray
public class Solution6 {
    public static long maxSum(int[] arr, int m, int k) {
        if (m == 1) return Solution.maxSum(arr, k);
        long trivial = checkTrivial(arr, m, k);
        if (trivial != -1) return trivial;

        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, curSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length * 2; right++) {
            int num = arr[right % arr.length];
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
            curSum += num;
            while (map.size() > k) {
                int leftNum = arr[left % arr.length];
                map.compute(leftNum, (key, value) -> value == 1 ? null : value - 1);
                curSum -= leftNum;
                left++;
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static long dummyMaxSum(int[] arr, int m, int k) {
        if (m == 1) return Solution.maxSum(arr, k);
        long trivial = checkTrivial(arr, m, k);
        if (trivial != -1) return trivial;

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

    private static long checkTrivial(int[] arr, int m, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        if (set.size() <= k) {
            long sum = 0;
            for (int num : arr) sum += num;
            return sum * m;
        }
        return -1;
    }
}

package help_requests.two_bags;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// only positive values
// massive is circle
// at most k different values allowed in subarray
public class Solution4 {
    public static long maxSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, curSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length * 2; right++) {
            int num = arr[right % arr.length];
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
            curSum += num;
            while (map.size() > k || right - left + 1 > arr.length) {
                int leftNum = arr[left % arr.length];
                map.compute(leftNum, (key, value) -> value == 1 ? null : value - 1);
                curSum -= leftNum;
                left++;
            }
            maxSum = Math.max(maxSum, curSum);
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
}

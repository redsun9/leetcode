package help_requests.two_bags;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// only positive values
// at most k different values allowed in subarray
@SuppressWarnings("DataFlowIssue")
public class Solution {
    public static long maxSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, curSum = 0;
        int left = 0;
        for (int num : arr) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
            curSum += num;
            while (map.size() > k) {
                int leftNum = arr[left++];
                map.compute(leftNum, (key, value) -> value == 1 ? null : value - 1);
                curSum -= leftNum;
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
            for (int j = i; j < n; j++) {
                if (set.size() < k || set.contains(arr[j])) {
                    set.add(arr[j]);
                    curSum += arr[j];
                    maxSum = Math.max(maxSum, curSum);
                } else break;
            }
        }
        return maxSum;
    }
}

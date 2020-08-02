package leetcode.leetcode3xx.leetcode347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution2 {
    Random random = new Random();

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        int n = count.size();
        int[] ans = new int[n];
        int[] freq = new int[n];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans[i] = entry.getKey();
            freq[i] = entry.getValue();
            i++;
        }
        quickSelect(ans, freq, n - k);
        return Arrays.copyOfRange(ans, n - k, n);
    }

    //partially sort array. make k smallest element to be in a[0..k) places
    private void quickSelect(int[] ans, int[] freq, int target) {
        int lo = 0;
        int hi = ans.length - 1;
        while (lo < target && hi + 1 > target) {
            int mid = partition(ans, freq, lo, hi);
            if (mid == target) return;
            if (mid < target) lo = mid + 1;
            else hi = mid - 1;
        }
    }

    private int partition(int[] ans, int[] freq, int left, int right) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = freq[pivotIndex];
        swap(ans, right, pivotIndex);
        swap(freq, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (freq[i] < pivotValue) {
                swap(ans, storeIndex, i);
                swap(freq, storeIndex, i);
                storeIndex++;
            }
        }
        swap(ans, right, storeIndex);
        swap(freq, right, storeIndex);
        return storeIndex;
    }
}

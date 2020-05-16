package leetcode.leetcode10xx.leetcode1095;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int n = arr.length();
        int lo = 0;
        int hi = n - 1;
        boolean meetInRight = false;
        int posInRight = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int left, right;
            if (cache.containsKey(mid)) left = cache.get(mid);
            else {
                left = arr.get(mid);
                cache.put(mid, left);
            }
            if (cache.containsKey(mid + 1)) right = cache.get(mid + 1);
            else {
                right = arr.get(mid + 1);
                cache.put(mid + 1, right);
            }
            if (left < right) {
                if (left == target) return mid;
                if (right == target) return mid + 1;
                lo = mid + 1;
            } else {
                if (left == target) {
                    meetInRight = true;
                    posInRight = mid;
                }
                hi = mid;
            }
        }
        int peak = lo;
        if (cache.get(peak) == target) return peak;
        if (cache.get(peak) < target) return -1;
        lo = 0;
        hi = peak - 1;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getKey() >= lo && entry.getKey() <= hi) {
                if (entry.getValue() < target) lo = entry.getKey() + 1;
                if (entry.getValue() > target) hi = entry.getKey() - 1;
            }
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if (val < target) lo = mid + 1;
            else hi = mid - 1;
        }
        if (lo == hi && arr.get(lo) == target) return lo;
        if (meetInRight) return posInRight;
        lo = peak + 1;
        hi = n - 1;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getKey() >= lo && entry.getKey() <= hi) {
                if (entry.getValue() > target) lo = entry.getKey() + 1;
                if (entry.getValue() < target) hi = entry.getKey() - 1;
            }
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if (val > target) lo = mid + 1;
            else hi = mid - 1;
        }
        if (lo == hi && arr.get(lo) == target) return lo;
        return -1;
    }
}

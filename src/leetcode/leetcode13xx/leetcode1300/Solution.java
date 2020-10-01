package leetcode.leetcode13xx.leetcode1300;

//binary search on answer

public class Solution {
    public int findBestValue(int[] arr, int target) {
        int lo = target / arr.length, hi = 0, sumLo = 0, sumHi = 0;
        for (int a : arr) {
            sumHi += a;
            hi = Math.max(hi, a);
            sumLo += Math.min(lo, a);
        }
        if (sumHi <= target) return hi;
        if (sumLo == target) return lo;

        int ans, min;
        if (target - sumLo <= sumHi - target) {
            ans = lo;
            min = target - sumLo;
        } else {
            ans = hi;
            min = sumHi - target;
        }
        lo++;
        hi--;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            for (int a : arr) sum += Math.min(mid, a);
            if (sum == target) return mid;
            int diff = Math.abs(target - sum);
            if (diff < min || diff == min && mid < ans) {
                ans = mid;
                min = diff;
            }
            if (sum > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return ans;
    }
}

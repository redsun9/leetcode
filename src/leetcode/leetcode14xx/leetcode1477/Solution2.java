package leetcode.leetcode14xx.leetcode1477;

// O(n) - time, O(1) - space
// !! work only for positive numbers
public class Solution2 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, l1 = 0, r1 = 0, l2 = 0, r2 = 0, ans = Integer.MAX_VALUE, minLeft = Integer.MAX_VALUE;
        long pref1 = 0, pref2 = 0;
        while (true) {
            //find next right subarray
            while ((r2 != n || pref2 > target) && pref2 != target) {
                //don't forget that left border can still walk and lower pref2 while right border is already == n
                if (pref2 < target) pref2 += arr[r2++];
                else pref2 -= arr[l2++];
            }
            if (pref2 != target) return ans != Integer.MAX_VALUE ? ans : -1; // there is no subarrays

            //now we process all left subarrays until r1==l2
            //don't forget that left border can still walk and lower pref1 while r1==l2
            while ((r1 != l2 || pref1 > target)) {
                if (pref1 >= target) pref1 -= arr[l1++];
                else pref1 += arr[r1++];
                if (pref1 == target) minLeft = Math.min(minLeft, r1 - l1);
            }

            if (minLeft != Integer.MAX_VALUE) ans = Math.min(ans, minLeft + r2 - l2);
            pref2 -= arr[l2++]; //don't forget to move right array
        }
    }
}

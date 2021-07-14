package leetcode.leetcode15xx.leetcode1521;

public class Solution {
    private static final int MAX_BITS = 20;

    private static int addVal(int val, int sum, int[] count) {
        for (int i = 0; i < MAX_BITS; i++) count[i] += 1 - (val >> i & 1);
        return sum & val;
    }

    private static int delVal(int val, int sum, int[] count) {
        for (int i = 0; i < MAX_BITS; i++) {
            if ((val >> i & 1) == 0) {
                if (--count[i] == 0) sum |= 1 << i;
            }
        }
        return sum;
    }

    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        if (n == 1) return Math.abs(target - arr[0]);
        if (target == 0) {
            int sum = arr[0];
            for (int a : arr) sum &= a;
            return sum;
        }
        int maxValue = arr[0];
        for (int a : arr) {
            if (a == target) return 0;
            maxValue = Math.max(maxValue, a);
        }
        if (target > maxValue) return target - maxValue;

        int[] count = new int[MAX_BITS];
        int ans = Integer.MAX_VALUE;

        for (int right = 0, left = 0, curr = (1 << MAX_BITS) - 1; right < n; right++) {
            curr = addVal(arr[right], curr, count);
            ans = Math.min(ans, Math.abs(target - curr));
            while (curr < target && left < right) {
                curr = delVal(arr[left++], curr, count);
                ans = Math.min(ans, Math.abs(target - curr));
            }
        }
        return ans;
    }
}

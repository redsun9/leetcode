package leetcode.leetcode9xx.leetcode978;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;
        int ans = 1;
        for (int i = 1, up = 1, down = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) up = down + 1;
            if (arr[i] < arr[i - 1]) down = up + 1;
            if (arr[i] >= arr[i - 1]) down = 1;
            if (arr[i] <= arr[i - 1]) up = 1;
            ans = Math.max(ans, up);
            ans = Math.max(ans, down);
        }
        return ans;
    }
}

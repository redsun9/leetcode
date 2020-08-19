package leetcode.leetcode9xx.leetcode995;

public class Solution2 {
    public int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        if (n == k) {
            int val = arr[0];
            for (int a : arr) if (a != val) return -1;
            return 1 - val;
        }
        int ans = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) current -= arr[i - k];
            if ((current & 1) == arr[i]) {
                arr[i] = 1;
                current++;
                ans++;
            } else arr[i] = 0;
        }
        current -= arr[n - k];
        return current == 0 ? ans : -1;
    }
}

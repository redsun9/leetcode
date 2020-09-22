package leetcode.leetcode15xx.leetcode1588;

public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //left-right, odd+odd, even+even
            ans += arr[i] * (
                    (i / 2 + 1) * ((n - 1 - i) / 2 + 1) +
                            ((i + 1) / 2) * ((n - 1 - i + 1) / 2)
            );
        }
        return ans;
    }
}

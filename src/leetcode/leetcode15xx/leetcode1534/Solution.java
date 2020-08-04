package leetcode.leetcode15xx.leetcode1534;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = n - 3; i >= 0; i--) {
            for (int j = n - 2; j > i; j--) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = n - 1; k > j; k--) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

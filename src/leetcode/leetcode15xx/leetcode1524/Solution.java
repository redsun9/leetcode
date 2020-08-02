package leetcode.leetcode15xx.leetcode1524;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1, odd = 0, sum = 0;
        long ans = 0;
        for (int a : arr) {
            sum ^= a;
            if ((sum & 1) == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
        }
        return (int) (ans % 1_000_000_007);
    }
}

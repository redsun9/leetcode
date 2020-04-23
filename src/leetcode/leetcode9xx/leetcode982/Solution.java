package leetcode.leetcode9xx.leetcode982;

public class Solution {
    public int countTriplets(int[] nums) {
        int n = 1 << 16;
        int[] tmp = new int[n];
        for (int a : nums) {
            for (int b : nums) {
                tmp[a & b]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (tmp[i] != 0) {
                for (int num : nums) {
                    if ((i & num) == 0) ans += tmp[i];
                }
            }
        }
        return ans;
    }
}

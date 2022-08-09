package leetcode.leetcode23xx.leetcode2367;

public class Solution {
    private static final int MAX_VAL = 200;

    public int arithmeticTriplets(int[] nums, int diff) {
        int[] cnt1 = new int[MAX_VAL + 1];
        int[] cnt2 = new int[MAX_VAL + 1];
        int ans = 0;
        for (int num : nums) {
            if (num >= diff) {
                ans += cnt2[num - diff];
                cnt2[num] += cnt1[num - diff];
            }
            cnt1[num]++;
        }
        return ans;
    }
}

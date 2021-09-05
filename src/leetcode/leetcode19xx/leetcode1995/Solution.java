package leetcode.leetcode19xx.leetcode1995;

public class Solution {
    private static final int MAX_NUM = 100;

    public int countQuadruplets(int[] nums) {
        int[] count1 = new int[MAX_NUM + 1];
        int[] count2 = new int[MAX_NUM + 1];
        int[] count3 = new int[MAX_NUM + 1];

        int ans = 0;
        for (int num : nums) {
            ans += count3[num];
            for (int i = MAX_NUM, j = MAX_NUM - num; j >= 0; i--, j--) {
                count3[i] += count2[j];
                count2[i] += count1[j];
            }
            count1[num]++;
        }
        return ans;
    }
}

package leetcode.leetcode9xx.leetcode985;

public class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int m = queries.length;
        int sum = 0;
        for (int num : nums) if ((num & 1) == 0) sum += num;
        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            int addVal = queries[j][0];
            int i = queries[j][1];
            int prevVal = nums[i];
            if ((prevVal & 1) == 0) {
                if ((addVal & 1) == 0) sum += addVal;
                else sum -= prevVal;
            } else if ((addVal & 1) != 0) sum += prevVal + addVal;
            nums[i] += addVal;
            ans[j] = sum;
        }
        return ans;
    }
}

package leetcode.leetcode37xx.leetcode3780;

public class Solution {
    public int maximumSum(int[] nums) {
        int[][] max = new int[3][3];
        for (int num : nums) {
            int rem = num % 3;
            int[] row = max[rem];
            if (row[2] < num) {
                if (row[1] < num) {
                    if (row[0] < num) {
                        row[2] = row[1];
                        row[1] = row[0];
                        row[0] = num;
                    } else {
                        row[2] = row[1];
                        row[1] = num;
                    }
                } else {
                    row[2] = num;
                }
            }
        }

        int ans = 0;
        for (int[] row : max) {
            if (row[2] != 0) ans = Math.max(ans, row[0] + row[1] + row[2]);
        }
        if (max[0][0] != 0 && max[1][0] != 0 && max[2][0] != 0) ans = Math.max(ans, max[0][0] + max[1][0] + max[2][0]);

        return ans;
    }
}

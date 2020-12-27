package leetcode.leetcode16xx.leetcode1664;

public class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int totalDiff = 0;
        for (int i = 0; i < n; i += 2) totalDiff += nums[i];
        for (int i = 1; i < n; i += 2) totalDiff -= nums[i];

        int ans = 0;
        int currDiff = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if ((i & 1) == 0) {
                if (currDiff == totalDiff - num) {
                    ans++;
                }
                currDiff += 2 * num;
            } else {
                if (currDiff == totalDiff + num) {
                    ans++;
                }
                currDiff -= 2 * num;
            }
        }
        return ans;
    }
}

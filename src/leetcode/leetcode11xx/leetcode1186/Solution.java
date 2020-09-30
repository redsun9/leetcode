package leetcode.leetcode11xx.leetcode1186;

public class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int maxNoDelete = 0;
        int maxWithDelete = 0;
        int maxValue = arr[0];
        int ans = 0;
        for (int num : arr) {
            maxWithDelete = Math.max(maxNoDelete, maxWithDelete + num);
            maxNoDelete = Math.max(maxNoDelete + num, num);
            ans = Math.max(ans, maxNoDelete);
            ans = Math.max(ans, maxWithDelete);
            maxValue = Math.max(maxValue, num);
        }
        return ans != 0 ? ans : maxValue;
    }
}

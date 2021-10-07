package leetcode.leetcode3xx.leetcode370;

public class Solution {
    /**
     * @param n:       the length of the array
     * @param updates: update operations
     * @return the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int n, int[][] updates) {
        int[] ans = new int[n];
        for (int[] update : updates) {
            ans[update[0]] += update[2];
            if (update[1] != n - 1) ans[update[1] + 1] -= update[2];
        }
        for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
        return ans;
    }
}

package leetcode.leetcode23xx.leetcode2358;

public class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int ans = (int) (Math.round(Math.sqrt(8 * n + 1) - 1) / 2);
        if (ans * (ans + 1) / 2 > n) ans--;
        return ans;
    }
}

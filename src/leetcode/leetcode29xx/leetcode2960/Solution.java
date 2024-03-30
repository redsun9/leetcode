package leetcode.leetcode29xx.leetcode2960;

public class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int a : batteryPercentages) if (a > ans) ans++;
        return ans;
    }
}

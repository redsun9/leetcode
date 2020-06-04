package leetcode.leetcode13xx.leetcode1375;

public class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        for (int i = light.length - 1, j = light.length - 1; i >= 0; i--) {
            j = Math.min(j, light[i] - 1);
            if (i == j) ans++;
        }
        return ans;
    }
}

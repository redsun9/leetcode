package leetcode.leetcode7xx.leetcode739;

public class Solution3 {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (ans[j] != 0 && t[i] >= t[j]) j += ans[j];
            ans[i] = t[i] < t[j] ? j - i : 0;
        }
        return ans;
    }
}

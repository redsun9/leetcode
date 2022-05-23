package leetcode.leetcode7xx.leetcode739;

public class Solution2 {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];

        int maxTemp = t[n - 1], currentTemp;
        for (int i = n - 2; i >= 0; i--) {
            currentTemp = t[i];
            if (currentTemp >= maxTemp) {
                maxTemp = currentTemp;
                continue;
            }

            int j = i + 1;
            while (t[j] <= currentTemp) j += ans[j];
            ans[i] = j - i;
        }
        return ans;
    }
}

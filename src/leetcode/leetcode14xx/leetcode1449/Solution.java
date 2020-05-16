package leetcode.leetcode14xx.leetcode1449;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] cost, int target) {
        int[][] dp = new int[target + 1][]; //10 - суммарное количество цифр
        dp[0] = new int[10];
        for (int i = 1; i <= target; i++) {
            int[] max = null;
            for (int j = 0; j < 9; j++) {
                int prevI = i - cost[j];
                if (prevI >= 0) {
                    int[] tmp = dp[prevI];
                    if (tmp != null) {
                        if (max == null) {
                            max = Arrays.copyOf(tmp, 10);
                            max[j]++;
                            max[9]++;
                        } else {
                            //сравниваем два
                            boolean isGreater = false;
                            if (tmp[9] + 1 != max[9]) {
                                isGreater = tmp[9] + 1 > max[9];
                            } else {
                                for (int k = 8; k >= 0; k--) {
                                    if (tmp[k] + (k == j ? 1 : 0) != max[k]) {
                                        isGreater = tmp[k] + (k == j ? 1 : 0) > max[k];
                                        break;
                                    }
                                }
                            }
                            if (isGreater) {
                                max = Arrays.copyOf(tmp, 10);
                                max[j]++;
                                max[9]++;
                            }
                        }
                    }
                }
            }
            dp[i] = max;
        }
        int[] ans = dp[target];
        if (ans == null) return "0";
        StringBuilder sb = new StringBuilder(ans[9]);
        for (int i = 9; i >= 1; i--) {
            sb.append(String.valueOf(i).repeat(ans[i - 1]));
        }
        return sb.toString();
    }
}

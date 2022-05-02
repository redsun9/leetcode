package leetcode.leetcode22xx.leetcode2262;

import java.util.Arrays;

public class Solution {
    public long appealSum(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        long ans = 0, sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            sum = sum - last[c] + i;
            last[c] = i;
            ans += sum;
        }
        return ans;
    }
}

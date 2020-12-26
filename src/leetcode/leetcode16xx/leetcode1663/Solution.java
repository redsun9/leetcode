package leetcode.leetcode16xx.leetcode1663;

import java.util.Arrays;

public class Solution {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        int numberOfA = n - (k - n + 24) / 25;
        int numberOfZ = (k - n) / 25;
        Arrays.fill(ans, 0, numberOfA, 'a');
        Arrays.fill(ans, n - numberOfZ, n, 'z');
        int middleValue = (k - n) % 25;
        if (middleValue != 0) {
            ans[n - 1 - numberOfZ] = (char) ('a' + middleValue);
        }
        return new String(ans);
    }
}

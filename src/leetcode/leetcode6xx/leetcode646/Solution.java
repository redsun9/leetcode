package leetcode.leetcode6xx.leetcode646;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n < 2) return n;
        Arrays.sort(pairs, Comparator.comparingInt(x -> x[1]));
        int ans = 0, i = 0;
        while (i < n) {
            int tmp = pairs[i++][1];
            while (i < n && pairs[i][0] <= tmp) i++;
            ans++;
        }
        return ans;
    }
}

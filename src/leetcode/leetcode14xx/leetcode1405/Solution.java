package leetcode.leetcode14xx.leetcode1405;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int n = a + b + c;
        int[] count = {a, b, c};
        int prev = -1;
        StringBuilder sb = new StringBuilder(n);
        while (true) {
            int max = 0;
            int maxI = 0;
            int totalMax = 0;
            for (int i = 0; i < 3; i++) {
                if (i != prev && count[i] > max) {
                    max = count[i];
                    maxI = i;
                }
                if (totalMax < count[i]) totalMax = count[i];
            }
            if (max == 0) return sb.toString();
            if (max == totalMax && max > 1) {
                sb.append((char) ('a' + maxI)).append((char) ('a' + maxI));
                count[maxI] -= 2;
            } else {
                sb.append((char) ('a' + maxI));
                count[maxI] -= 1;
            }
            prev = maxI;
        }
    }
}

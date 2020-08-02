package leetcode.leetcode15xx.leetcode1525;

public class Solution {
    public int numSplits(String s) {
        int n = s.length();
        if (n <= 2) return n / 2;
        int[] leftCount = new int[26];
        int[] rightCount = new int[26];
        int leftDistinct = 0;
        int rightDistinct = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (rightCount[c]++ == 0) rightDistinct++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (leftCount[c]++ == 0) leftDistinct++;
            if (--rightCount[c] == 0) rightDistinct--;
            if (leftDistinct == rightDistinct) ans++;
        }
        return ans;
    }
}

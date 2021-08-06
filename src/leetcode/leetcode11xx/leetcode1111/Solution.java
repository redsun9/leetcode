package leetcode.leetcode11xx.leetcode1111;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (a > b) {
                    b++;
                    ans[i] = 1;
                } else a++;
            } else {
                if (b > a) {
                    b--;
                    ans[i] = 1;
                } else a--;
            }
        }
        return ans;
    }
}

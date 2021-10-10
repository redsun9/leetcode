package leetcode.leetcode4xx.leetcode484;

public class Solution {
    /**
     * @param s: a string
     * @return return a list of integers
     */
    public int[] findPermutation(String s) {
        int n = s.length();
        if (n == 0) return new int[]{1};
        int[] ans = new int[n + 1];
        int lo = 1;
        int left = 0;
        while (left < n) {
            char c = s.charAt(left);
            int right = left + 1;
            while (right < n && s.charAt(right) == c) right++;
            if (c == 'I') {
                while (left < right) ans[left++] = lo++;
            } else {
                int i = right;
                while (i >= left) ans[i--] = lo++;
                left = right + 1;
            }
        }
        if (left == n) ans[n] = lo;
        return ans;
    }
}


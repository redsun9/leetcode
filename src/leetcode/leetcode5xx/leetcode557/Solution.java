package leetcode.leetcode5xx.leetcode557;

public class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        char[] ans = s.toCharArray();
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                reverse(ans, start, i - 1);
                start = i + 1;
            }
        }
        reverse(ans, start, n - 1);
        return new String(ans);
    }

    private static void reverse(char[] nums, int from, int to) {
        while (from < to) swap(nums, from++, to--);
    }

    private static void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

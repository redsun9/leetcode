package leetcode.leetcode4xx.leetcode434;

public class Solution {
    public int countSegments(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && (i == n - 1 || s.charAt(i + 1) == ' ')) ans++;
        }
        return ans;
    }
}

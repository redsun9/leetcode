package leetcode.leetcode1xx.leetcode151;

public class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder(s.trim().length());
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(" ").append(split[i]);
        }
        return sb.substring(1);
    }
}

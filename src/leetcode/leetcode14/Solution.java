package leetcode.leetcode14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, minLength);
    }
}

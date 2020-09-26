package leetcode.leetcode7xx.leetcode709;

public class Solution {
    public static final char d = 'a' - 'A';

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') chars[i] = (char) (c + d);
        }
        return new String(chars);
    }
}

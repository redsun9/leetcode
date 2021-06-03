package leetcode.leetcode9xx.leetcode917;

public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; ) {
            if (!Character.isLetter(chars[i])) i++;
            else if (!Character.isLetter(chars[j])) j--;
            else {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }
}

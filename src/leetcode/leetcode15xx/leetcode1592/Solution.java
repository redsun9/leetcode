package leetcode.leetcode15xx.leetcode1592;

import java.util.Arrays;

public class Solution {
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int numberOfWords = 0;
        int numberOfSpaces = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (chars[right] == ' ') {
                numberOfSpaces++;
                if (right != left) numberOfWords++;
                left = right + 1;
            }
        }
        if (left != n) numberOfWords++;
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');
        int spacesBetween = numberOfWords != 1 ? numberOfSpaces / (numberOfWords - 1) : 0;
        int i = 0, pos = 0;
        while (numberOfWords != 0) {
            while (chars[i] == ' ') i++;
            while (i < n && chars[i] != ' ') ans[pos++] = chars[i++];
            if (--numberOfWords != 0) pos += spacesBetween;
        }
        return new String(ans);
    }
}

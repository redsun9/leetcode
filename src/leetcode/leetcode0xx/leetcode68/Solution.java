package leetcode.leetcode0xx.leetcode68;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Text Justification
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        LinkedList<String> ans = new LinkedList<>();
        int n = words.length;
        int start = 0;
        int currentLength = 0;
        int i = 0;
        char[] chars = new char[maxWidth];
        while (true) {
            while (i < n && currentLength + words[i].length() + i - start <= maxWidth)
                currentLength += words[i++].length();
            if (i != n) {
                int curPos = 0;
                for (char c : words[start].toCharArray()) {
                    chars[curPos++] = c;
                }
                if (i - start == 1) {
                    Arrays.fill(chars, curPos, maxWidth, ' ');
                } else {
                    int spaces = maxWidth - currentLength;
                    for (int j = start + 1; j < i; j++) {
                        int spaceN = spaces / (i - j);
                        if (spaces % (i - j) != 0) spaceN++;
                        spaces -= spaceN;
                        Arrays.fill(chars, curPos, curPos + spaceN, ' ');
                        curPos += spaceN;
                        for (char c : words[j].toCharArray()) {
                            chars[curPos++] = c;
                        }
                    }
                }
                ans.add(new String(chars));
                currentLength = 0;
                start = i;
            } else {
                int curPos = 0;
                for (char c : words[start].toCharArray()) {
                    chars[curPos++] = c;
                }
                for (int j = start + 1; j < i; j++) {
                    chars[curPos++] = ' ';
                    for (char c : words[j].toCharArray()) {
                        chars[curPos++] = c;
                    }
                }
                Arrays.fill(chars, curPos, maxWidth, ' ');
                ans.add(new String(chars));
                break;
            }
        }
        return ans;
    }
}

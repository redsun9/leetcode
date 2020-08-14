package leetcode.leetcode8xx.leetcode806;

public class Solution {
    private static final int MAX_WIDTH = 100;

    public int[] numberOfLines(int[] widths, String s) {
        int curWidth = 0;
        int numberOfLines = 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            curWidth += widths[c];
            if (curWidth > MAX_WIDTH) {
                curWidth = widths[c];
                numberOfLines++;
            }
        }
        return new int[]{numberOfLines, curWidth};
    }
}

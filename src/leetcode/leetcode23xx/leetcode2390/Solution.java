package leetcode.leetcode23xx.leetcode2390;

public class Solution {
    public String removeStars(String s) {
        char[] array = s.toCharArray();
        int n = s.length(), start = n;
        for (int i = n - 1, starCount = 0; i >= 0; i--) {
            if (array[i] == '*') starCount++;
            else if (starCount != 0) starCount--;
            else array[--start] = array[i];
        }
        return new String(array, start, n - start);
    }
}

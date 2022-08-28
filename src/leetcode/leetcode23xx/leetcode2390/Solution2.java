package leetcode.leetcode23xx.leetcode2390;

public class Solution2 {
    public String removeStars(String s) {
        char[] array = s.toCharArray();
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') count--;
            else array[count++] = array[i];
        }
        return new String(array, 0, count);
    }
}

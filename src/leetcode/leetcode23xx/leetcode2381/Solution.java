package leetcode.leetcode23xx.leetcode2381;

public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] total = new int[n + 1];
        for (int[] shift : shifts) {
            total[shift[0]] += (shift[2] * 2 - 1);
            total[shift[1] + 1] -= (shift[2] * 2 - 1);
        }

        char[] chars = s.toCharArray();
        for (int i = 0, sum = 0; i < n; i++) {
            sum += total[i];
            int ord = (chars[i] - 'a' + sum) % 26;
            if (ord < 0) ord += 26;
            chars[i] = (char) (ord + 'a');
        }
        return new String(chars);
    }
}

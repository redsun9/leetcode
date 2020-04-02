package leetcode.leetcode13xx.leetcode1374;

import java.util.Arrays;

public class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n];
        if (n % 2 == 0) {
            Arrays.fill(chars, 0, n - 1, 'a');
            chars[n - 1] = 'b';
        } else {
            Arrays.fill(chars, 'a');
        }
        return new String(chars);
    }
}

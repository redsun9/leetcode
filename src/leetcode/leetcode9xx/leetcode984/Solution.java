package leetcode.leetcode9xx.leetcode984;

public class Solution {
    public String strWithout3a3b(int a, int b) {
        char[] s = new char[a + b];
        int pos = 0;
        if (b > a) {
            s[pos++] = 'b';
            b--;
            if (b != 0) {
                s[pos++] = 'b';
                b--;
            }
        }
        while (a != 0 || b != 0) {
            if (a != 0) {
                s[pos++] = 'a';
                a--;
            }
            if (a > b) {
                s[pos++] = 'a';
                a--;
            }
            if (b != 0) {
                s[pos++] = 'b';
                b--;
            }
            if (b > a) {
                s[pos++] = 'b';
                b--;
            }
        }
        return new String(s);
    }
}

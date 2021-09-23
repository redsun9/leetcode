package leetcode.leetcode2xx.leetcode246;

public class Solution {

    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        while (i < j) {
            char c1 = num.charAt(i++), c2 = num.charAt(j--);
            if (
                    (c1 != '0' || c2 != '0') &&
                            (c1 != '1' || c2 != '1') &&
                            (c1 != '6' || c2 != '9') &&
                            (c1 != '8' || c2 != '8') &&
                            (c1 != '9' || c2 != '6')
            ) return false;
        }
        if (i != j) return true;
        else {
            char c = num.charAt(i);
            return c == '0' || c == '1' || c == '8';
        }
    }
}

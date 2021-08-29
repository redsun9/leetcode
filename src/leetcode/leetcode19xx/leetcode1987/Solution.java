package leetcode.leetcode19xx.leetcode1987;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numberOfUniqueGoodSubsequences(String binary) {
        long num1 = 0, num2 = 0;
        boolean hasZero = false;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                num1 = num1 + num2 + 1;
                if (num1 >= p) num1 -= p;
            } else {
                hasZero = true;
                num2 = num1 + num2 + 1;
                if (num2 >= p) num2 -= p;
            }
        }
        if (hasZero) {
            num1++;
            if (num1 >= p) num1 -= p;
        }
        return (int) num1;
    }
}

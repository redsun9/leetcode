package leetcode.leetcode10xx.leetcode1012;

public class Solution {
    private static final int[][] a;
    private static final int[] b;

    static {
        //a[i][j] = i!/j!, i>=j
        a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            a[i][i] = 1;
            for (int j = i; j > 0; j--) {
                a[i][j - 1] = a[i][j] * j;
            }
        }

        //b = number of positive integers with non repeating digits less than 10^n
        b = new int[10];
        b[0] = 0;
        b[1] = 9;
        for (int i = 2, j = 9; i < 10; i++, j--) {
            b[i] = b[i - 1] * j;
        }
        for (int i = 2; i < 10; i++) {
            b[i] += b[i - 1];
        }
    }

    public int numDupDigitsAtMostN(int n) {
        if (n <= 10) return 0;
        int[] digits = new int[10];
        int digitCounter = 0;
        int tmp = n;
        while (tmp != 0) {
            digits[digitCounter++] = tmp % 10;
            tmp /= 10;
        }
        int nonRepeating = 0;
        boolean[] used = new boolean[10];
        boolean nIsWithoutRepeating = true;
        for (int i = digitCounter - 1; i >= 0; i--) {
            int lessNotUsed = 0;
            for (int j = i == digitCounter - 1 ? 1 : 0; j < digits[i]; j++) {
                if (!used[j]) lessNotUsed++;
            }
            nonRepeating += lessNotUsed * a[10 - digitCounter + i][10 - digitCounter];
            if (used[digits[i]]) {
                nIsWithoutRepeating = false;
                break;
            }
            used[digits[i]] = true;
        }
        nonRepeating += b[digitCounter - 1];
        nonRepeating += nIsWithoutRepeating ? 1 : 0;

        return n - nonRepeating;
    }
}

package leetcode.leetcode20xx.leetcode2081;

import java.util.Arrays;

public class Generator {
    private static final int minK = 2, maxK = 9, maxN = 30, maxKDigit = 60, maxTenDigit = 18;

    private static final long[][] arr = new long[maxK + 1][maxN + 1];
    private static final long[][] pow = new long[maxK + 1][maxKDigit + 1];
    private static final long[] tenPos = new long[maxTenDigit + 1];
    private static final int[] curNumOfDigits = new int[maxK + 1];
    private static final int[] curNumOfFound = new int[maxK + 1];


    public static void main(String[] args) {
        int left = maxK - minK + 1;
        for (int k = minK; k <= maxK; k++) {
            curNumOfDigits[k] = 1;
            pow[k][0] = 1;
            pow[k][1] = k;
        }

        tenPos[0] = 1;
        for (int i = 1; i < maxTenDigit; i++) tenPos[i] = tenPos[i - 1] * 10;

        int curTenDigit = 1;
        long minHalf = 1;
        while (left != 0) {
            long half = minHalf, maxHalf = minHalf * 10;
            while (left != 0 && half < maxHalf) {
                long fullNum = getFull(half++, curTenDigit, true);
                for (int k = minK; k <= maxK; k++) {
                    if (check(fullNum, k)) if (curNumOfFound[k] == maxN) left--;
                }
            }

            half = minHalf;
            while (left != 0 && half < maxHalf) {
                long fullNum = getFull(half++, curTenDigit, false);
                for (int k = minK; k <= maxK; k++) {
                    if (check(fullNum, k)) if (curNumOfFound[k] == maxN) left--;
                }
            }

            minHalf *= 10;
            curTenDigit++;
        }

        for (int k = minK; k <= maxK; k++) {
            System.out.println(Arrays.toString(arr[k]));
        }
    }

    private static long getFull(long half, int curTenDigit, boolean odd) {
        long fullNum = half;
        for (int i = odd ? 1 : 0; i < curTenDigit; i++) fullNum = fullNum * 10 + half % tenPos[i + 1] / tenPos[i];
        return fullNum;
    }

    private static boolean check(long fullNum, int k) {
        if (curNumOfFound[k] >= maxN) return false;
        while (pow[k][curNumOfDigits[k]] <= fullNum) {
            pow[k][curNumOfDigits[k] + 1] = pow[k][curNumOfDigits[k]] * k;
            curNumOfDigits[k]++;
        }
        boolean ok = true;
        for (int i = 0, j = curNumOfDigits[k] - 1; i < j; i++, j--) {
            ok = fullNum % pow[k][i + 1] / pow[k][i] == fullNum % pow[k][j + 1] / pow[k][j];
            if (!ok) break;
        }
        if (ok) {
            arr[k][curNumOfFound[k] + 1] = arr[k][curNumOfFound[k]] + fullNum;
            curNumOfFound[k]++;
        }
        return ok;
    }
}

package leetcode.leetcode22xx.leetcode2212;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int n = 11;

    @Test
    void test1() {
        int numArrows = 9;
        int[] aliceArrows = {1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0};
        int[] expected = {0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1};
        int[] bobArrows = new Solution().maximumBobPoints(numArrows, aliceArrows);
        checkResult(aliceArrows, expected, bobArrows);
    }

    @Test
    void test2() {
        int numArrows = 3;
        int[] aliceArrows = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0};
        int[] bobArrows = new Solution().maximumBobPoints(numArrows, aliceArrows);
        checkResult(aliceArrows, expected, bobArrows);
    }


    private void checkResult(int[] aliceArrows, int[] expected, int[] actual) {
        int expectedScore = calculateScore(aliceArrows, expected);
        int actualScore = calculateScore(aliceArrows, actual);
        assertEquals(n + 1, actual.length);
        assertTrue(nonNegative(actual));
        assertEquals(sum(expected), sum(expected));
        assertEquals(expectedScore, actualScore);
    }

    private boolean nonNegative(int[] arr) {
        for (int a : arr) if (a < 0) return false;
        return true;
    }

    private int sum(int[] arr) {
        int ans = 0;
        for (int i = 0; i <= n; i++) ans += arr[i];
        return ans;
    }

    private int calculateScore(int[] aliceArrows, int[] bobArrows) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (aliceArrows[i] < bobArrows[i]) ans += i;
        }
        return ans;
    }
}
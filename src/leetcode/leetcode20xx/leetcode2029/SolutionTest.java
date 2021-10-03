package leetcode.leetcode20xx.leetcode2029;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    @Test
    void test1() {
        int[] stones = {2, 3, 1};
        assertFalse(new Solution().stoneGameIX(stones));
        assertFalse(new Solution2().stoneGameIX(stones));
    }

    @Test
    void test2() {
        int[] stones = {15, 20, 10, 13, 14, 15, 5, 2, 3};
        assertFalse(new Solution().stoneGameIX(stones));
        assertFalse(new Solution2().stoneGameIX(stones));
    }

    @Test
    @Disabled
    void test3() {
        for (int a = 0; a < 100; a++) {
            for (int b = 0; b < 100; b++) {
                for (int c = 0; c < 100; c++) {
                    if (a == 0 && b == 0 && c == 0) continue;
                    boolean expected = b != 0 && check(a, b - 1, c, 1) || c != 0 && check(a, b, c - 1, 2);
                    assertEquals(expected, Solution.solve(a, b, c));
                    assertEquals(expected, Solution2.solve(a, b, c));
                }
            }
        }
    }

    private static boolean check(int a, int b, int c, int sum) {
        boolean first = true;
        while (a != 0 || b != 0 || c != 0) {
            if (c != 0 && sum != 1) {
                c--;
                first = !first;
                sum += 2;
                sum %= 3;
            } else if (b != 0 && sum != 2) {
                b--;
                first = !first;
                sum += 1;
                sum %= 3;
            } else if (a != 0) {
                a--;
                first = !first;
            } else break;
        }
        if (a + b + c == 0) return false;
        else return first;
    }
}
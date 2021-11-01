package leetcode.leetcode20xx.leetcode2056;

import org.junit.jupiter.api.Test;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    @Test
    void testRook() {
        String[] pieces = {"rook"};
        int[][] positions = new int[1][2];

        for (int k = 0; k < 64; k++) {
            int i = k % 8, j = k / 8;
            positions[0][0] = i + 1;
            positions[0][1] = j + 1;
            assertEquals(15, new Solution().countCombinations(pieces, positions));
        }
    }

    @Test
    void testBishop() {
        String[] pieces = {"bishop"};
        int[][] positions = new int[1][2];

        for (int k = 0; k < 64; k++) {
            int i = k % 8, j = k / 8;
            positions[0][0] = i + 1;
            positions[0][1] = j + 1;
            int expected = 1 + min(i, j) + min(i, 7 - j) + min(7 - i, j) + min(7 - i, 7 - j);
            assertEquals(expected, new Solution().countCombinations(pieces, positions));
        }
    }

    @Test
    void testQueen() {
        String[] pieces = {"queen"};
        int[][] positions = new int[1][2];

        for (int k = 0; k < 64; k++) {
            int i = k % 8, j = k / 8;
            positions[0][0] = i + 1;
            positions[0][1] = j + 1;
            int expected = 15 + min(i, j) + min(i, 7 - j) + min(7 - i, j) + min(7 - i, 7 - j);
            assertEquals(expected, new Solution().countCombinations(pieces, positions));
        }
    }

    @Test
    void test4() {
        String[] pieces = {"rook", "rook"};
        int[][] positions = {{1, 1}, {8, 8}};
        assertEquals(223, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test5() {
        String[] pieces = {"queen", "bishop"};
        int[][] positions = {{5, 7}, {3, 4}};
        assertEquals(281, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test6() {
        String[] pieces = {"queen", "queen", "queen", "queen"};
        int[][] positions = {{4, 4}, {4, 5}, {5, 4}, {5, 5}};
        assertEquals(354264, new Solution().countCombinations(pieces, positions));
    }
}
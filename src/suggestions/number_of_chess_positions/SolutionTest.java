package suggestions.number_of_chess_positions;

import org.junit.jupiter.api.Test;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testKnight() {
        String[] pieces = {"knight"};
        int[][] positions = new int[1][2];

        for (int k = 0; k < 64; k++) {
            int i = k % 8, j = k / 8;
            positions[0][0] = i + 1;
            positions[0][1] = j + 1;

            int a = Math.min(i, 7 - i), b = Math.min(j, 7 - j);
            int x = Math.min(a, b), y = Math.max(a, b);
            int expected;
            if (y == 0) expected = 3;
            else if (y == 1 && x == 0) expected = 4;
            else if (y == 1 || x == 0) expected = 5;
            else if (x == 1) expected = 7;
            else expected = 9;
            assertEquals(expected, new Solution().countCombinations(pieces, positions));
        }
    }

    @Test
    void testKing() {
        String[] pieces = {"king"};
        int[][] positions = new int[1][2];

        for (int k = 0; k < 64; k++) {
            int i = k % 8, j = k / 8;
            positions[0][0] = i + 1;
            positions[0][1] = j + 1;

            int a = Math.min(i, 7 - i), b = Math.min(j, 7 - j);
            int x = Math.min(a, b), y = Math.max(a, b);
            int expected;
            if (y == 0) expected = 4;
            else if (x == 0) expected = 6;
            else expected = 9;
            assertEquals(expected, new Solution().countCombinations(pieces, positions));
        }
    }

    @Test
    void testTwoRooks() {
        String[] pieces = {"rook", "rook"};
        int[][] positions = new int[2][2];

        for (int k1 = 0; k1 < 64; k1++) {
            int i1 = k1 % 8, j1 = k1 / 8;
            positions[0][0] = i1 + 1;
            positions[0][1] = j1 + 1;
            for (int k2 = 0; k2 < 64; k2++) {
                if (k1 == k2) continue;
                int i2 = k2 % 8, j2 = k2 / 8;
                positions[1][0] = i2 + 1;
                positions[1][1] = j2 + 1;
                int cross = i1 == i2 || j1 == j2 ? 8 : 2;
                int expected = 15 * 15 - cross;
                assertEquals(expected, new Solution().countCombinations(pieces, positions));
            }
        }
    }

    @Test
    void testTwoBishops() {
        String[] pieces = {"bishop", "bishop"};
        int[][] positions = new int[2][2];

        for (int k1 = 0; k1 < 64; k1++) {
            int i1 = k1 % 8, j1 = k1 / 8;
            positions[0][0] = i1 + 1;
            positions[0][1] = j1 + 1;
            for (int k2 = 0; k2 < 64; k2++) {
                if (k1 == k2) continue;
                int i2 = k2 % 8, j2 = k2 / 8;
                positions[1][0] = i2 + 1;
                positions[1][1] = j2 + 1;

                int exp1 = 1 + min(i1, j1) + min(i1, 7 - j1) + min(7 - i1, j1) + min(7 - i1, 7 - j1);
                int exp2 = 1 + min(i2, j2) + min(i2, 7 - j2) + min(7 - i2, j2) + min(7 - i2, 7 - j2);

                int cross;
                if (((i1 ^ i2 ^ j1 ^ j2) & 1) != 0) cross = 0;
                else if (i1 + j1 == i2 + j2) cross = Math.min(1 + i1 + j1, 15 - (i1 + j1));
                else if (i1 - j1 == i2 - j2) cross = Math.min(8 + (i1 - j1), 8 - (i1 - j1));
                else {
                    cross = 0;
                    int d11 = i1 + j1, d12 = i1 - j1, d21 = i2 + j2, d22 = i2 - j2;
                    int i3 = (d11 + d22) / 2, j3 = (d11 - d22) / 2, i4 = (d21 + d12) / 2, j4 = (d21 - d12) / 2;
                    if (i3 >= 0 && i3 < 8 && j3 >= 0 && j3 < 8) cross++;
                    if (i4 >= 0 && i4 < 8 && j4 >= 0 && j4 < 8) cross++;
                }

                int expected = exp1 * exp2 - cross;
                assertEquals(expected, new Solution().countCombinations(pieces, positions));
            }
        }
    }

    @Test
    void test1() {
        String[] pieces = {"queen", "bishop"};
        int[][] positions = {{5, 7}, {3, 4}};
        int expected = 285;
        assertEquals(expected, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test2() {
        String[] pieces = {"queen", "queen"};
        int[][] positions = {{5, 7}, {3, 4}};
        int expected = 616;
        assertEquals(expected, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test3() {
        String[] pieces = {"queen", "queen", "queen", "queen"};
        int[][] positions = {{5, 7}, {3, 4}, {4, 5}, {6, 3}};
        int expected = 412758;
        assertEquals(expected, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test4() {
        String[] pieces = {"queen", "queen", "queen", "queen"};
        int[][] positions = {{4, 4}, {4, 5}, {5, 4}, {5, 5}};
        int expected = 556876;
        assertEquals(expected, new Solution().countCombinations(pieces, positions));
    }

    @Test
    void test5() {
        String[] pieces = {"queen", "queen", "queen", "queen", "queen", "queen"};
        int[][] positions = new int[6][2];
        for (int i = 0; i < 6; i++) {
            positions[i][0] = 2 + i;
            positions[i][1] = 1 + (1 + i * 3) % 8;
        }
        long expected = 160670419L;
        assertEquals(expected, new Solution().countCombinations(pieces, positions));
    }
}
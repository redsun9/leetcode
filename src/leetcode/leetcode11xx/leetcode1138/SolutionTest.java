package leetcode.leetcode11xx.leetcode1138;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        check("leet", "DDR!UURRR!!DDD!");
    }

    @Test
    void test2() {
        check("code", "RR!DDRR!UUL!R!");
    }

    private static void check(String target, String sampleOutput) {
        int expectedLength = sampleOutput.length();
        String ans = new Solution().alphabetBoardPath(target);
        assertEquals(expectedLength, ans.length());
        int x = 0, y = 0, pos = 0, n = target.length(), m = ans.length();
        for (int i = 0; i < m; i++) {
            switch (ans.charAt(i)) {
                case 'U' -> x--;
                case 'D' -> x++;
                case 'L' -> y--;
                case 'R' -> y++;
                case '!' -> assertEquals(target.charAt(pos++), 'a' + x * 5 + y);
            }
            assertTrue(x >= 0 && x <= 5 && y >= 0 && y < 5 && x * 5 + y <= 25);
        }
        assertEquals(pos, n);
    }
}
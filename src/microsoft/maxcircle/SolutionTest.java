package microsoft.maxcircle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "ABDCA";
        int[] x = {2, -1, 4, -3, 3};
        int[] y = {2, -1, 4, 1, -3};
        assertEquals(3, new Solution().solution(s, x, y));
    }

    @Test
    void test2() {
        String s = "ABB";
        int[] x = {1, -2, -2};
        int[] y = {1, -2, 2};
        assertEquals(1, new Solution().solution(s, x, y));
    }
}
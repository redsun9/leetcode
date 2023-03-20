package help_requests.game2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] row = {0, 0, 1, 0, 1, 2, 4, 8, 8};
        Solution.processLeftSwipe(row);
        int[] expected = {16, 8, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, row);
    }

    @Test
    void test2() {
        int[] row = {1, 1, 1, 2, 1, 1, 1, 4, 1};
        Solution.processLeftSwipe(row);
        int[] expected = {2, 1, 4, 1, 4, 1, 0, 0, 0};
        assertArrayEquals(expected, row);
    }

    @Test
    void test3() {
        int[] row = {1, 1, 2, 4};
        Solution.processRightSwipe(row);
        int[] expected = {0, 0, 0, 8};
        assertArrayEquals(expected, row);
    }

    @Test
    void test4() {
        int[] row = {1, 0, 1, 1};
        Solution.processRightSwipe(row);
        int[] expected = {0, 0, 1, 2};
        assertArrayEquals(expected, row);
    }
}
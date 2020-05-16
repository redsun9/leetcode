package leetcode.leetcode13xx.leetcode1301;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        List<String> board = Arrays.asList("E23", "2X2", "12S");
        assertArrayEquals(new int[]{7, 1}, new Solution().pathsWithMaxScore(board));
    }

    @Test
    void test2() {
        List<String> board = Arrays.asList("E12", "1X1", "21S");
        assertArrayEquals(new int[]{4, 2}, new Solution().pathsWithMaxScore(board));
    }

    @Test
    void test3() {
        List<String> board = Arrays.asList("E11", "XXX", "11S");
        assertArrayEquals(new int[]{0, 0}, new Solution().pathsWithMaxScore(board));
    }
}
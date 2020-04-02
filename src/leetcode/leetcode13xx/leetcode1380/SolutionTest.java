package leetcode.leetcode13xx.leetcode1380;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        List<Integer> list = solution.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
        Collections.sort(list);
        assertEquals(Collections.singletonList(15), list);
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        List<Integer> list = solution.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}});
        Collections.sort(list);
        assertEquals(Collections.singletonList(12), list);
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        List<Integer> list = solution.luckyNumbers(new int[][]{{7, 8}, {1, 2}});
        Collections.sort(list);
        assertEquals(Collections.singletonList(7), list);
    }
}
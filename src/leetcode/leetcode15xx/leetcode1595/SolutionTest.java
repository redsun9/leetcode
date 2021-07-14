package leetcode.leetcode15xx.leetcode1595;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<List<Integer>> cost = List.of(
                List.of(15, 96),
                List.of(36, 2)
        );
        assertEquals(17, new Solution().connectTwoGroups(cost));
    }

    @Test
    void test2() {
        List<List<Integer>> cost = List.of(
                List.of(1, 3, 5),
                List.of(4, 1, 1),
                List.of(1, 5, 3)
        );
        assertEquals(4, new Solution().connectTwoGroups(cost));
    }

    @Test
    void test3() {
        List<List<Integer>> cost = List.of(
                List.of(2, 5, 1),
                List.of(3, 4, 7),
                List.of(8, 1, 2),
                List.of(6, 2, 4),
                List.of(3, 8, 8)
        );
        assertEquals(10, new Solution().connectTwoGroups(cost));
    }
}
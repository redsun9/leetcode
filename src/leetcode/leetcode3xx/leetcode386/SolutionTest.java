package leetcode.leetcode3xx.leetcode386;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<Integer> expected = List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, new Solution().lexicalOrder(13));
    }
}
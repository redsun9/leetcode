package leetcode.leetcode22xx.leetcode2218;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        List<List<Integer>> piles = List.of(List.of(37, 88), List.of(51, 64, 65, 20, 95, 30, 26), List.of(9, 62, 20), List.of(44));
        assertEquals(494, new Solution().maxValueOfCoins(piles, 9));
    }

}
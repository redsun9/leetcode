package leetcode.leetcode19xx.leetcode1916;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] prevRoom = {-1, 0, 1};
        assertEquals(1, new Solution().waysToBuildRooms(prevRoom));
    }

    @Test
    void test2() {
        int[] prevRoom = {-1, 0, 0, 1, 2};
        assertEquals(6, new Solution().waysToBuildRooms(prevRoom));
    }
}
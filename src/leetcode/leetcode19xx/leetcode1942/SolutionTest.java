package leetcode.leetcode19xx.leetcode1942;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        assertEquals(1, new Solution().smallestChair(times, targetFriend));
    }

    @Test
    void test2() {
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend = 0;
        assertEquals(2, new Solution().smallestChair(times, targetFriend));
    }
}
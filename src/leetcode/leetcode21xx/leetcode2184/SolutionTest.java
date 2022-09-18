package leetcode.leetcode21xx.leetcode2184;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] bricks = {2, 1};
        for (int width = 3; width < 20; width++) {
            for (int height = 2; height < 100; height++) {
                assertEquals(2, new Solution().buildWall(height, width, bricks));
                assertEquals(2, new Solution2().buildWall(height, width, bricks));
            }
        }
    }

    @Test
    void test2() {
        int[] bricks = {2};
        for (int width = 5; width < 20; width++) {
            for (int height = 2; height < 100; height++) {
                assertEquals(0, new Solution().buildWall(height, width, bricks));
                assertEquals(0, new Solution2().buildWall(height, width, bricks));
            }
        }
    }

    @Test
    void test3() {
        int[] bricks = {2, 3};
        for (int height = 2; height < 100; height++) {
            assertEquals(2, new Solution().buildWall(height, 6, bricks));
            assertEquals(2, new Solution2().buildWall(height, 6, bricks));
        }
    }

    @Test
    void test4() {
        int[] bricks = {1, 2, 3};
        assertEquals(12, new Solution().buildWall(2, 4, bricks));
        assertEquals(12, new Solution2().buildWall(2, 4, bricks));
    }

    @Test
    void test5() {
        int[] bricks = {1};
        assertEquals(1, new Solution().buildWall(1, 1, bricks));
        assertEquals(1, new Solution2().buildWall(1, 1, bricks));
    }


    @Test
    void test6() {
        int[] bricks = {7, 5, 4, 10, 6, 8, 9, 3, 2, 1};
        assertEquals(392098753, new Solution().buildWall(61, 10, bricks));
    }

    @Test
    void test7() {
        int[] bricks = {7, 5, 4, 10, 6, 8, 9, 3, 2, 1};
        assertEquals(392098753, new Solution2().buildWall(61, 10, bricks));
    }
}
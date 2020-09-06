package leetcode.leetcode15xx.leetcode1575;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1, finish = 3, fuel = 5;
        assertEquals(4, new Solution().countRoutes(locations, start, finish, fuel));
    }

    @Test
    void test2() {
        int[] locations = {4, 3, 1};
        int start = 1, finish = 0, fuel = 6;
        assertEquals(5, new Solution().countRoutes(locations, start, finish, fuel));
    }

    @Test
    void test3() {
        int[] locations = {5, 2, 1};
        int start = 0, finish = 2, fuel = 3;
        assertEquals(0, new Solution().countRoutes(locations, start, finish, fuel));
    }

    @Test
    void test4() {
        int[] locations = {2, 1, 5};
        int start = 0, finish = 0, fuel = 3;
        assertEquals(2, new Solution().countRoutes(locations, start, finish, fuel));
    }

    @Test
    void test5() {
        int[] locations = {1, 2, 3};
        int start = 0, finish = 2, fuel = 40;
        assertEquals(615088286, new Solution().countRoutes(locations, start, finish, fuel));
    }
}
package leetcode.leetcode23xx.leetcode2398;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] chargeTimes = {3, 6, 1, 3, 4};
        int[] runningCosts = {2, 1, 3, 4, 5};
        long budget = 25;

        assertEquals(3, new Solution().maximumRobots(chargeTimes, runningCosts, budget));
    }

    @Test
    void test2() {
        int[] chargeTimes = {11, 12, 19};
        int[] runningCosts = {10, 8, 7};
        long budget = 19;

        assertEquals(0, new Solution().maximumRobots(chargeTimes, runningCosts, budget));
    }


    @Test
    void test3() {
        int[] chargeTimes = {11, 12, 74, 67, 37, 87, 42, 34, 18, 90, 36, 28, 34, 20};
        int[] runningCosts = {18, 98, 2, 84, 7, 57, 54, 65, 59, 91, 7, 23, 94, 20};
        long budget = 937;
        assertEquals(4, new Solution().maximumRobots(chargeTimes, runningCosts, budget));
    }
}
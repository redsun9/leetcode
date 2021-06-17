package leetcode.leetcode16xx.leetcode1687;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] boxes = {{1, 1}, {2, 1}, {1, 1}};
        int portsCount = 2, maxBoxes = 3, maxWeight = 3;
        assertEquals(4, new Solution().boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    void test2() {
        int[][] boxes = {{1, 2}, {3, 3}, {3, 1}, {3, 1}, {2, 4}};
        int portsCount = 3, maxBoxes = 3, maxWeight = 6;
        assertEquals(6, new Solution().boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    void test3() {
        int[][] boxes = {{1, 4}, {1, 2}, {2, 1}, {2, 1}, {3, 2}, {3, 4}};
        int portsCount = 3, maxBoxes = 6, maxWeight = 7;
        assertEquals(6, new Solution().boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    void test4() {
        int[][] boxes = {{2, 4}, {2, 5}, {3, 1}, {3, 2}, {3, 7}, {3, 1}, {4, 4}, {1, 3}, {5, 2}};
        int portsCount = 5, maxBoxes = 5, maxWeight = 7;
        assertEquals(14, new Solution().boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }
}
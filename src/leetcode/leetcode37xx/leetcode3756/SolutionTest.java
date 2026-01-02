package leetcode.leetcode37xx.leetcode3756;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        assertArrayEquals(new int[]{444444137}, new Solution().sumAndMultiply("9876543210", new int[][]{{0, 9}}));
    }

    @Test
    void test2() {
        String s = "2711785625";
        int[][] queries = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 7}, {0, 8}, {0, 9}, {1, 3}, {1, 4}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {2, 3}, {2, 4}, {2, 6}, {2, 7}, {2, 8}, {2, 9}, {3, 4}, {3, 5}, {4, 4}, {4, 5}, {4, 6}, {4, 7}, {4, 8}, {4, 9}, {5, 5}, {5, 7}, {5, 8}, {5, 9}, {6, 6}, {6, 7}, {6, 8}, {7, 7}, {7, 8}, {7, 9}, {8, 9}};
        int[] expected = {4, 243, 2710, 29821, 488106, 7050628, 3360665, 575963848, 318566667, 6399, 113872, 20641765, 249124960, 633606780, 894996047, 22, 1053, 259270, 3299968, 35356860, 412496875, 136, 2848, 49, 1170, 15700, 204256, 2199736, 25925625, 64, 16264, 179802, 2226250, 25, 616, 7306, 36, 496, 8125, 175};
        assertArrayEquals(expected, new Solution().sumAndMultiply(s, queries));
    }
}
package leetcode.leetcode37xx.leetcode3743;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 3};
        int k = 2;
        long expected = 3;
        assertEquals(expected, new Solution().maximumScore(nums, k));
        assertEquals(expected, new Solution2().maximumScore(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 3};
        int k = 2;
        long expected = 3;
        assertEquals(expected, new Solution().maximumScore(nums, k));
        assertEquals(expected, new Solution2().maximumScore(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 3};
        int k = 4;
        long expected = 3;
        assertEquals(expected, new Solution().maximumScore(nums, k));
        assertEquals(expected, new Solution2().maximumScore(nums, k));
    }

    @Test
    void test4() {
        int[] nums = {124, 143, 80, 188, 192, 173, 168, 125, 55, 109, 81, 7, 125, 105, 38, 156, 76, 81, 55, 29, 51, 33, 188, 151, 106, 11, 161, 196, 188, 126, 174, 87, 189, 69, 85, 162, 124, 28, 1, 198, 8, 96, 166, 72, 108, 176, 149, 60, 100, 57, 148, 180, 18, 151, 26, 167, 70, 151, 5, 102, 75, 182, 96, 104, 48, 93, 97, 155, 150, 183, 32, 190, 144, 195, 109, 86, 67, 86, 25, 159, 46, 114, 62, 49, 26, 115, 180, 43, 1, 173, 160, 48, 92, 190, 15, 190, 79, 61, 42, 22, 138, 189, 84, 123, 158, 21, 147, 150, 84, 8, 11, 83, 30, 27, 107, 123, 98, 148, 90, 71, 155, 147, 146, 10, 62, 163, 70, 51, 171, 170, 188, 141, 1, 191, 162};
        int k = 97;
        long expected = 5690;
        assertEquals(expected, new Solution().maximumScore(nums, k));
        assertEquals(expected, new Solution2().maximumScore(nums, k));
    }
}
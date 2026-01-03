package leetcode.leetcode37xx.leetcode3721;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 5, 4, 3};
        assertEquals(4, new Solution().longestBalanced(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 2, 2, 5, 4};
        assertEquals(5, new Solution().longestBalanced(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 2};
        assertEquals(3, new Solution().longestBalanced(nums));
    }

    @Test
    void test4() {
        int[] nums = {84, 4, 54, 45, 4, 30, 44, 54, 21, 54, 27, 56, 37, 13, 7, 39, 1, 55, 5, 7, 70, 63, 62, 2, 57, 24, 64, 34, 64, 16, 69, 27, 33, 75};
        assertEquals(32, new Solution().longestBalanced(nums));
    }

    @Test
    void test5() {
        int[] nums = {2, 3, 10, 18, 3, 9, 5};
        assertEquals(7, new Solution().longestBalanced(nums));
    }

    @Test
    void stressTest() throws InterruptedException {
        Solution solution = new Solution();
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int n = 20;
                    int[] nums = new int[n];
                    for (int i = 0; i < n; i++) {
                        nums[i] = random.nextInt(1, 100);
                    }
                    return nums;
                },
                SolutionTest::dummy,
                solution::longestBalanced,
                1_000_000
        ));
    }


    private static int dummy(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int balance = 0;
            for (int j = i; j < n; j++) {
                if (set.add(nums[j])) balance += (nums[j] & 1) == 0 ? 1 : -1;
                if (balance == 0) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
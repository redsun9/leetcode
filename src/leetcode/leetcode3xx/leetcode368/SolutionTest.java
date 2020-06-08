package leetcode.leetcode3xx.leetcode368;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        List<Integer> result = new Solution().largestDivisibleSubset(nums);
        int n = result.size();
        assertEquals(2, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                assertTrue(result.get(i) % result.get(j) == 0 || result.get(j) % result.get(i) == 0);
            }
        }
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = new Solution().largestDivisibleSubset(nums);
        assertEquals(4, result.size());
        assertEquals(Set.of(1, 2, 4, 8), new HashSet<>(result));
    }
}
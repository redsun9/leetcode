package leetcode.leetcode3xx.leetcode324;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        Map<Integer, Integer> before = countMap(nums);

        new Solution().wiggleSort(nums);

        Map<Integer, Integer> after = countMap(nums);
        assertEquals(before, after);

        for (int i = 1; i < nums.length; i += 2) assertTrue(nums[i] > nums[i - 1]);
        for (int i = 2; i < nums.length; i += 2) assertTrue(nums[i] < nums[i - 1]);
    }

    @Test
    void test2() {
        int[] nums = {1, 3, 2, 2, 3, 1};
        Map<Integer, Integer> before = countMap(nums);

        new Solution().wiggleSort(nums);

        Map<Integer, Integer> after = countMap(nums);
        assertEquals(before, after);

        for (int i = 1; i < nums.length; i += 2) assertTrue(nums[i] > nums[i - 1]);
        for (int i = 2; i < nums.length; i += 2) assertTrue(nums[i] < nums[i - 1]);
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 2, 2, 1};
        Map<Integer, Integer> before = countMap(nums);

        new Solution().wiggleSort(nums);

        Map<Integer, Integer> after = countMap(nums);
        assertEquals(before, after);

        for (int i = 1; i < nums.length; i += 2) assertTrue(nums[i] > nums[i - 1]);
        for (int i = 2; i < nums.length; i += 2) assertTrue(nums[i] < nums[i - 1]);
    }


    private static Map<Integer, Integer> countMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }
}
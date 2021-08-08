package leetcode.leetcode19xx.leetcode1960;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(9, new Solution().maxProduct("ababbb"));
        assertEquals(9, new Solution2().maxProduct("ababbb"));
    }

    @Test
    void test2() {
        assertEquals(9, new Solution().maxProduct("zaaaxbbby"));
        assertEquals(9, new Solution2().maxProduct("zaaaxbbby"));
    }

    @Test
    void test3() {
        char[] arr = new char[100_000];
        Arrays.fill(arr, 'a');
        assertEquals(2499999999L, new Solution().maxProduct(new String(arr)));
    }

    @Test
    void test4() {
        char[] arr = new char[100_000];
        Arrays.fill(arr, 'a');
        assertEquals(2499999999L, new Solution2().maxProduct(new String(arr)));
    }

    @Test
    void test5() {
        char[] arr = new char[100_000];
        for (int i = 0; i < 100_000; i++) arr[i] = (char) ('a' + (i & 1));
        for (int i = 2; i < 26; i++) arr[100_000 - 26 + i] = (char) ('a' + i);
        assertEquals(2498800143L, new Solution().maxProduct(new String(arr)));
    }

    @Test
    void test6() {
        char[] arr = new char[100_000];
        for (int i = 0; i < 100_000; i++) arr[i] = (char) ('a' + (i & 1));
        for (int i = 2; i < 26; i++) arr[100_000 - 26 + i] = (char) ('a' + i);
        assertEquals(2498800143L, new Solution2().maxProduct(new String(arr)));
    }
}
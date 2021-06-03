package leetcode.leetcode10xx.leetcode1071;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String str1 = "ABCABC", str2 = "ABC";
        assertEquals("ABC", new Solution().gcdOfStrings(str1, str2));
    }

    @Test
    void test2() {
        String str1 = "ABABAB", str2 = "ABAB";
        assertEquals("AB", new Solution().gcdOfStrings(str1, str2));
    }

    @Test
    void test3() {
        String str1 = "LEET", str2 = "CODE";
        assertEquals("", new Solution().gcdOfStrings(str1, str2));
    }

    @Test
    void test4() {
        String str1 = "ABCDEF", str2 = "ABC";
        assertEquals("", new Solution().gcdOfStrings(str1, str2));
    }
}
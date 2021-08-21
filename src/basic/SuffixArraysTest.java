package basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SuffixArraysTest {

    @Test
    void testSuffixArray1() {
        int[] arr = {2, 1, 1, 4, 3};
        int[] suffixArray = SuffixArrays.buildSuffixArray(arr, 4);
        int[] expected = {1, 2, 0, 4, 3};
        assertArrayEquals(expected, suffixArray);
    }

    @Test
    void testSuffixArray2() {
        int[] arr = {1, 2, 1, 3, 1, 2, 1};
        int[] suffixArray = SuffixArrays.buildSuffixArray(arr, 3);
        int[] expected = {6, 4, 0, 2, 5, 1, 3};
        assertArrayEquals(expected, suffixArray);
    }

    @Test
    void testInverseSuffixArray() {
        int[] arr = {2, 1, 1, 4, 3};
        int[] invSuffixArray = SuffixArrays.buildInverseSuffixArray(arr, 4);
        int[] expected = {2, 0, 1, 4, 3};
        assertArrayEquals(expected, invSuffixArray);
    }

    @Test
    void testLCP() {
        int[] arr = {1, 1, 2, 1, 1, 3, 1};
        int[] suffixArray = SuffixArrays.buildSuffixArray(arr, 4);

        // 1,1121131,1131,121131,131,21131,3
        int[] expectedSuffixArray = {6, 0, 3, 1, 4, 2, 5};
        assertArrayEquals(expectedSuffixArray, suffixArray);

        int[] invSuffixArray = SuffixArrays.inverseSuffixArray(suffixArray);
        int[] lcp = SuffixArrays.buildLongestCommonPrefixArray(arr, suffixArray, invSuffixArray);

        // 1 and 1121131 has common prefix of length 1
        // 1121131 and 1131 has common prefix of length 2
        int[] lcpExpected = {1, 2, 1, 1, 0, 0};
        assertArrayEquals(lcpExpected, lcp);
    }
}
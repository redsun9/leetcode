package basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SuffixArraysTest {

    @Test
    void test1() {
        int[] arr = {2, 1, 1, 4, 3};
        int[] suffixArray = SuffixArrays.buildSuffixArray(arr, 4);
        int[] expected = {1, 2, 0, 4, 3};
        assertArrayEquals(expected, suffixArray);
    }

    @Test
    void test2() {
        int[] arr = {1, 2, 1, 3, 1, 2, 1};
        int[] suffixArray = SuffixArrays.buildSuffixArray(arr, 3);
        int[] expected = {6, 4, 0, 2, 5, 1, 3};
        assertArrayEquals(expected, suffixArray);
    }
}
package leetcode.leetcode10xx.leetcode1095;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        MountainArrayImpl mountainArray = new MountainArrayImpl(arr);
        assertEquals(2, new Solution().findInMountainArray(3, mountainArray));
    }

    @Test
    void test2() {
        int[] arr = {0, 1, 2, 4, 2, 1};
        MountainArrayImpl mountainArray = new MountainArrayImpl(arr);
        assertEquals(-1, new Solution().findInMountainArray(3, mountainArray));
    }


}
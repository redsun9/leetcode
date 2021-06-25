package leetcode.leetcode18xx.leetcode1865;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSumPairsTest {

    @Test
    void test1() {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs fsp = new FindSumPairs(nums1, nums2);
        assertEquals(8, fsp.count(7));
        fsp.add(3, 2);
        assertEquals(2, fsp.count(8));
        assertEquals(1, fsp.count(4));
        fsp.add(0, 1);
        fsp.add(1, 1);
        assertEquals(11, fsp.count(7));
    }
}
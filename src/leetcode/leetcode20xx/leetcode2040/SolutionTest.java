package leetcode.leetcode20xx.leetcode2040;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {2, 5}, nums2 = {3, 4};
        int k = 2;
        assertEquals(8, new Solution().kthSmallestProduct(nums1, nums2, k));
        assertEquals(8, new Solution2().kthSmallestProduct(nums1, nums2, k));
        assertEquals(8, new Solution3().kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    void test2() {
        int[] nums1 = {-4, -2, 0, 3}, nums2 = {2, 4};
        int k = 6;
        assertEquals(0, new Solution().kthSmallestProduct(nums1, nums2, k));
        assertEquals(0, new Solution2().kthSmallestProduct(nums1, nums2, k));
        assertEquals(0, new Solution3().kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    void test3() {
        int[] nums1 = {-2, -1, 0, 1, 2}, nums2 = {-3, -1, 2, 4, 5};
        int k = 3;
        assertEquals(-6, new Solution().kthSmallestProduct(nums1, nums2, k));
        assertEquals(-6, new Solution2().kthSmallestProduct(nums1, nums2, k));
        assertEquals(-6, new Solution3().kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    void test4() {
        int[] nums1 = {-8, 4, 6}, nums2 = {-6, -4, 6, 8};
        int k = 6;
        assertEquals(-16, new Solution().kthSmallestProduct(nums1, nums2, k));
        assertEquals(-16, new Solution2().kthSmallestProduct(nums1, nums2, k));
        assertEquals(-16, new Solution3().kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int miVal = -100, maxVal = 100, nMax = 100;
        int delta = maxVal - miVal + 1;

        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();

        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int n1 = 1 + random.nextInt(nMax), n2 = 1 + random.nextInt(nMax);
                    int[] nums1 = new int[n1], nums2 = new int[n2];
                    for (int i = 0; i < n1; i++) nums1[i] = miVal + random.nextInt(delta);
                    for (int i = 0; i < n2; i++) nums2[i] = miVal + random.nextInt(delta);
                    int k = 1 + random.nextInt(n1 * n2);
                    Arrays.sort(nums1);
                    Arrays.sort(nums2);
                    return new TestData(nums1, nums2, k);
                },
                t -> solution.kthSmallestProduct(t.nums1, t.nums2, t.k),
                t -> solution3.kthSmallestProduct(t.nums1, t.nums2, t.k),
                1_000_000
        ));
    }


    private static class TestData {
        int[] nums1, nums2;
        long k;

        @Override
        public String toString() {
            return "TestData{" +
                    "nums1=" + Arrays.toString(nums1) +
                    ", nums2=" + Arrays.toString(nums2) +
                    ", k=" + k +
                    '}';
        }

        public TestData(int[] nums1, int[] nums2, long k) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.k = k;

        }
    }
}
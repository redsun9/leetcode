package leetcode.leetcode14xx.leetcode1477;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {3, 2, 2, 4, 3};
        assertEquals(2, new Solution().minSumOfLengths(arr, 3));
        assertEquals(2, new Solution2().minSumOfLengths(arr, 3));
    }

    @Test
    void test2() {
        int[] arr = {7, 3, 4, 7};
        assertEquals(2, new Solution().minSumOfLengths(arr, 7));
        assertEquals(2, new Solution2().minSumOfLengths(arr, 7));
    }

    @Test
    void test3() {
        int[] arr = {4, 3, 2, 6, 2, 3, 4};
        assertEquals(-1, new Solution().minSumOfLengths(arr, 6));
        assertEquals(-1, new Solution2().minSumOfLengths(arr, 6));
    }

    @Test
    void test4() {
        int[] arr = {5, 5, 4, 4, 5};
        assertEquals(-1, new Solution().minSumOfLengths(arr, 3));
        assertEquals(-1, new Solution2().minSumOfLengths(arr, 3));
    }

    @Test
    void test5() {
        int[] arr = {3, 1, 1, 1, 5, 1, 2, 1};
        assertEquals(3, new Solution().minSumOfLengths(arr, 3));
        assertEquals(3, new Solution2().minSumOfLengths(arr, 3));
    }

    @Test
    void test6() {
        int[] arr = {64, 5, 20, 9, 1, 39};
        assertEquals(6, new Solution().minSumOfLengths(arr, 69));
        assertEquals(6, new Solution2().minSumOfLengths(arr, 69));
    }

    @Test
    void stressTest() throws InterruptedException {
        int n = 20, minTarget = 10, maxTarget = 100, minVal = 1, maxVal = 10;
        int valBound = maxVal - minVal + 1;
        int targetBound = maxTarget - minTarget + 1;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        StressTester.exactStressTest(
                seed -> {
                    int[] arr = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) arr[i] = minVal + random.nextInt(valBound);
                    return new TestData(arr, minTarget + random.nextInt(targetBound));
                },
                data -> solution.minSumOfLengths(data.arr, data.target),
                data -> solution2.minSumOfLengths(data.arr, data.target)
        );
    }

    private record TestData(int[] arr, int target) {
        @Override
        public String toString() {
            return "TestData{" +
                    "arr=" + Arrays.toString(arr) +
                    ", target=" + target +
                    '}';
        }
    }
}
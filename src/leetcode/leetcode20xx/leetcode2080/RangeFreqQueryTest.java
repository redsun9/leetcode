package leetcode.leetcode20xx.leetcode2080;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangeFreqQueryTest {

    @Test
    void test1() {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rq = new RangeFreqQuery(arr);
        assertEquals(1, rq.query(1, 2, 4));
        assertEquals(2, rq.query(0, 11, 33));
    }

    @Test
    void test2() throws InterruptedException {
        int n = 10, maxVal = 5;
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = random.nextInt(maxVal);
                    int a = random.nextInt(n), b = random.nextInt(n), val = random.nextInt(maxVal);
                    return new TestData(arr, Math.min(a, b), Math.max(a, b), val);
                },
                testData -> new RangeFreqQuery(testData.arr).query(testData.left, testData.right, testData.value),
                testData -> slowRangeFreqQuery(testData.arr, testData.left, testData.right, testData.value),
                10_000
        ));
    }

    private static int slowRangeFreqQuery(int[] arr, int left, int right, int value) {
        left = Math.max(left, 0);
        right = Math.min(right, arr.length - 1);

        int ans = 0;
        for (int i = left; i <= right; i++) if (arr[i] == value) ans++;
        return ans;
    }


    private static class TestData {
        final int left, right, value;
        final int[] arr;

        @Override
        public String toString() {
            return "TestData{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    ", arr=" + Arrays.toString(arr) +
                    '}';
        }

        public TestData(int[] arr, int left, int right, int value) {
            this.arr = arr;
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
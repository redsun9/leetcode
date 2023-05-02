package help_requests.max_zip;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int N = 30;
    private static final int MIN_VAL = -1;
    private static final int MAX_VAL = 6;
    private static final int MIN_THRESHOLD = 7;
    private static final int MAX_THRESHOLD = 15;


    @Test
    void test1() {
        int[] arr = {1, 1, 1};
        int[] actual = Solution.maxZip(arr, 2, 3);
        int[] expected = {3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        TestData testData = generate(-7269227409276787159L);
        int[] actual = solve(testData);
        assertTrue(check(testData, actual));
    }

    @Test
    void testRandom() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                SolutionTest::generate,
                SolutionTest::solve,
                SolutionTest::check,
                1_000_000
        ));
    }

    private static TestData generate(long seed) {
        int[] arr = new int[N];
        Random random = new Random(seed);
        for (int i = 0; i < N; i++) arr[i] = MIN_VAL + random.nextInt(MAX_VAL - MIN_VAL + 1);
        return new TestData(arr, MIN_THRESHOLD, MAX_THRESHOLD);
    }

    private static int[] solve(TestData testData) {
        return Solution.maxZip(testData.arr, testData.minThreshold, testData.maxThreshold);
    }

    private static boolean check(TestData testData, int[] actual) {
        if (actual == null) return false;
        int[] arr = testData.arr;
        int minThreshold = testData.minThreshold;
        int maxThreshold = testData.maxThreshold;
        int i1 = 0, i2 = 0, n1 = arr.length, n2 = actual.length;
        for (int num : actual) if (num < minThreshold || num > maxThreshold) return false;
        long curSum = 0;
        while (i1 < n1 && i2 < n2) {
            curSum += arr[i1++];
            if (actual[i2] == curSum) {
                curSum = 0;
                i2++;
            }
        }
        //check if the rest of actual could be 0
        if (curSum != 0 || i2 != n2) return false;
        while (i1 < n1) curSum += arr[i1++];
        return curSum == 0L;
    }

    private record TestData(int[] arr, int minThreshold, int maxThreshold) {

        @Override
        public String toString() {
            return "TestData{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }
    }
}
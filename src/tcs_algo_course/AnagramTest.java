package tcs_algo_course;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramTest {
    @Test
    void test1() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};
        int[] expected = {0, 0, 3};
        int[] actual = Anagram.maxLengthOfCommonAnagram(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testRandom() throws InterruptedException {
        int n = 1000, k = 10;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, k, seed),
                testData -> Anagram.maxLengthOfCommonAnagram(testData[0], testData[1]),
                (testData, actual) -> Anagram.check(testData[0], testData[1], actual[0], actual[1], actual[2], true),
                10_000,
                1,
                1_000
        ));
    }

    @Test
    void testRandomWithMinAns() throws InterruptedException {
        int n = 1000, k = 100_000;
        assertTrue(StressTester.constructionStressTest(
                seed -> generateWithMinAnswer(n, k, seed),
                testData -> Anagram.maxLengthOfCommonAnagram(testData[0], testData[1]),
                (testData, actual) -> actual[2] >= testData[2][2] && Anagram.check(testData[0], testData[1], actual[0], actual[1], actual[2], true),
                10_000,
                1,
                1_000
        ));
    }


    private static int[][] generate(int n, int k, long seed) {
        Random random = new Random(seed);
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1 + random.nextInt(k);
            arr[1][i] = 1 + random.nextInt(k);
        }
        return arr;
    }

    private static int[][] generateWithMinAnswer(int n, int k, long seed) {
        Random random = new Random(seed);
        int[][] arr = new int[3][];
        arr[0] = new int[n];
        arr[1] = new int[n];
        int minAns = 1 + random.nextInt(n);
        int start1 = random.nextInt(n - minAns + 1);
        int start2 = random.nextInt(n - minAns + 1);

        for (int i = 0, i1 = start1, i2 = start2; i < minAns; i++, i1++, i2++) {
            int val = 1 + random.nextInt(k);
            arr[0][i1] = val;
            arr[1][i2] = val;
        }

        for (int i = 0; i < start1; i++) arr[0][i] = 1 + random.nextInt(k);
        for (int i = start1 + minAns; i < n; i++) arr[0][i] = 1 + random.nextInt(k);
        for (int i = 0; i < start2; i++) arr[1][i] = 1 + random.nextInt(k);
        for (int i = start2 + minAns; i < n; i++) arr[1][i] = 1 + random.nextInt(k);
        arr[2] = new int[]{start1, start2, minAns};
        return arr;
    }
}
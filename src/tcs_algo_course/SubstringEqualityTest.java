package tcs_algo_course;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SubstringEqualityTest {
    @Test
    void testRandom() throws InterruptedException {
        int n = 100, k = 30, minLen = 10;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandom(n, seed, k, minLen),
                testData -> dummyCheck(testData.s, testData.a, testData.b, testData.c, testData.d),
                testData -> new SubstringEqualityRollingHash(testData.s).isEqual(testData.a, testData.b, testData.c, testData.d),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testTrue() throws InterruptedException {
        int n = 100, k = 30, minLen = 10;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandomTrue(n, seed, k, minLen),
                testData -> true,
                testData -> new SubstringEqualityRollingHash(testData.s).isEqual(testData.a, testData.b, testData.c, testData.d),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testFalse() throws InterruptedException {
        int n = 100, k = 30, minLen = 10;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandomFalse(n, seed, k, minLen),
                testData -> false,
                testData -> new SubstringEqualityRollingHash(testData.s).isEqual(testData.a, testData.b, testData.c, testData.d),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testLCP() throws InterruptedException {
        int n = 100, k = 26, minLen = 10;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandom(n, seed, k, minLen),
                testData -> dummyCheck(testData.s, testData.a, testData.b, testData.c, testData.d),
                testData -> new SubstringEqualityLCP(testData.s).isEqual(testData.a, testData.b, testData.c, testData.d),
                1_000_000,
                1,
                100_000
        ));
    }

    private static TestData generateRandom(int n, long seed, int k, int minLen) {
        Random random = new Random(seed);
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = (char) ('a' + random.nextInt(k));
        int len = minLen + random.nextInt(n - minLen + 1);
        int a = random.nextInt(n - len + 1);
        int c = random.nextInt(n - len + 1);
        return new TestData(new String(arr), a, a + len, c, c + len);
    }

    private static TestData generateRandomTrue(int n, long seed, int k, int minLen) {
        Random random = new Random(seed);
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = (char) ('a' + random.nextInt(k));
        int len = minLen + random.nextInt(n / 2 - minLen + 1);
        int a = random.nextInt(n / 2 - len + 1);
        int c = n / 2 + random.nextInt(n / 2 - len + 1);
        for (int i = 0, i1 = a, i2 = c; i < len; i++, i1++, i2++) {
            char ch = (char) ('a' + random.nextInt(k));
            arr[i1] = ch;
            arr[i2] = ch;
        }
        return new TestData(new String(arr), a, a + len, c, c + len);
    }

    private static TestData generateRandomFalse(int n, long seed, int k, int minLen) {
        Random random = new Random(seed);
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = (char) ('a' + random.nextInt(k));
        int len = minLen + random.nextInt(n / 2 - minLen + 1);
        int a = random.nextInt(n / 2 - len + 1);
        int c = n / 2 + random.nextInt(n / 2 - len + 1);
        for (int i = 0, i1 = a, i2 = c; i < len; i++, i1++, i2++) {
            char ch = (char) ('a' + random.nextInt(k));
            arr[i1] = ch;
            arr[i2] = ch;
        }
        int changedPos = random.nextInt(len);
        char changedChar = (char) ('a' + random.nextInt(k));
        while (arr[a + changedPos] == changedChar) changedChar = (char) ('a' + random.nextInt(k));
        arr[a + changedPos] = changedChar;

        return new TestData(new String(arr), a, a + len, c, c + len);
    }

    private static boolean dummyCheck(String s, int a, int b, int c, int d) {
        if (b - a != d - c) return false;
        for (int i = a, j = c; i < b; i++, j++) if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }

    private record TestData(String s, int a, int b, int c, int d) {
    }
}
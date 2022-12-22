package help_requests.find_subsequence;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testBinaryDense() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateDense(seed, 10_000, 1000, 1, 9),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution2.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testInterpolationDense() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateDense(seed, 10_000, 1000, 1, 9),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution3.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testBinarySparse() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateSparseTrue(seed, 1_000, 100, 1, 1_000_000),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution2.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testInterpolationSparse() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateSparseTrue(seed, 1_000, 100, 1, 1_000_000),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution3.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testBinarySparseFalse() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateSparseFalse(seed, 1_000, 100, 1, 1_000_000),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution2.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testInterpolationSparseFalse() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateSparseFalse(seed, 1_000, 100, 1, 1_000_000),
                test -> Solution.findSubsequence(test[0], test[1]),
                test -> Solution3.findSubsequence(test[0], test[1]),
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[][] generateDense(long seed, int m, int n, int minVal, int maxVal) {
        Random random = new Random(seed);
        int[][] ans = {new int[m], new int[n]};
        for (int i = 0; i < m; i++) ans[0][i] = minVal + random.nextInt(maxVal - minVal + 1);
        for (int i = 0; i < n; i++) ans[1][i] = minVal + random.nextInt(maxVal - minVal + 1);
        Arrays.sort(ans[0]);
        Arrays.sort(ans[1]);
        return ans;
    }

    private static int[][] generateSparseTrue(long seed, int m, int n, int minVal, int maxVal) {
        Random random = new Random(seed);
        int[][] ans = {new int[m], new int[n]};
        for (int i = 0; i < n; i++) {
            ans[1][i] = minVal + random.nextInt(maxVal - minVal + 1);
            ans[0][i] = ans[1][i];
        }

        for (int i = n; i < m; i++) ans[0][i] = minVal + random.nextInt(maxVal - minVal + 1);
        Arrays.sort(ans[0]);
        Arrays.sort(ans[1]);
        return ans;
    }

    private static int[][] generateSparseFalse(long seed, int m, int n, int minVal, int maxVal) {
        Random random = new Random(seed);
        int[][] ans = {new int[m], new int[n]};
        int missingVal = minVal + random.nextInt(maxVal - minVal + 1);

        for (int i = 0; i < n; i++) {
            int val = minVal + random.nextInt(maxVal - minVal);
            if (val >= missingVal) val++;
            ans[1][i] = val;
            ans[0][i] = ans[1][i];
        }

        ans[1][n - 1] = missingVal;

        for (int i = n; i < m; i++) {
            int val = minVal + random.nextInt(maxVal - minVal);
            if (val >= missingVal) val++;
            ans[0][i] = val;
        }
        Arrays.sort(ans[0]);
        Arrays.sort(ans[1]);
        return ans;
    }
}
package help_requests.bureaucracy_level;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    private static final int n = 1_000;

    @Test
    void testCorrectness() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::dummySolution,
                Solution::bureaucracyLevel,
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testCycleSolution() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::bureaucracyLevel,
                Solution::cycleSolution,
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testRecursiveSolution() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::bureaucracyLevel,
                Solution::recursiveSolution,
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testKahnSolution() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::bureaucracyLevel,
                Solution::kahnSolution,
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[] generate(long seed) {
        Random random = new Random(seed);
        int[] shuffled = new int[n];
        for (int i = 0; i < n; i++) shuffled[i] = i;
        for (int i = n - 1; i >= 2; i--) {
            int idx = 1 + random.nextInt(i);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[idx];
            shuffled[idx] = tmp;
        }


        int[] a = new int[n];
        a[0] = -1;
        for (int i = 1; i < n; i++) a[shuffled[i]] = shuffled[random.nextInt(i)];
        return a;
    }

    private static int[] generate(long seed, int n) {
        Random random = new Random(seed);
        int[] shuffled = new int[n];
        for (int i = 0; i < n; i++) shuffled[i] = i;
        for (int i = n - 1; i >= 2; i--) {
            int idx = 1 + random.nextInt(i);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[idx];
            shuffled[idx] = tmp;
        }


        int[] a = new int[n];
        a[0] = -1;
        for (int i = 1; i < n; i++) a[shuffled[i]] = shuffled[random.nextInt(i)];
        return a;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int[] p = generate(i + 1, i);
            int[] ans = Solution.maxHeightAndIndex(p);
            System.out.println(Arrays.toString(p) + " => h = " + ans[0] + ", index = " + ans[1]);
        }
    }
}
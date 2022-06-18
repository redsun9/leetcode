package suggestions.total_imbalance;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test() {
        Solution s = new Solution();
        Solution2 s2 = new Solution2();
        assertEquals(3, s.totalImbalance(new int[]{4, 1, 3, 2}));
        assertEquals(3, s2.totalImbalance(new int[]{4, 1, 3, 2}));
        assertEquals(0, s.totalImbalance(new int[]{1, 2, 3, 4}));
        assertEquals(0, s2.totalImbalance(new int[]{1, 2, 3, 4}));
    }

    @Test
    void testCorrectness() throws InterruptedException {
        int n = 20;
        Solution s = new Solution();
        Solution2 s2 = new Solution2();
        assertTrue(StressTester.exactStressTest(
                seed -> randomShuffle(n, seed),
                s2::totalImbalance,
                s::totalImbalance,
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[] randomShuffle(int n, long seed) {
        Random random = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
        return a;
    }
}
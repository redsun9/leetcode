package help_requests.min_nok;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

class SolutionTest {
    @Test
    void test() throws InterruptedException {
        StressTester.exactStressTest(
                seed -> new Random(seed).nextInt(2, 1_000_001),
                Solution::solve,
                SolutionTest::dummy,
                100_000,
                1,
                1000
        );
    }

    private static int dummy(int n) {
        long ans = 1, nok = n - 1;
        for (int i = 1, j = n - 1; i <= j; i++, j--) {
            long lcm = lcm(i, j);
            if (lcm < nok) {
                nok = lcm;
                ans = i;
            }
        }
        return (int) ans;
    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    //least common multiplier
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
package help_requests.collision_find;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testShort() {
        int maxLen = 6;
        for (int i = 0; i < 1_000_000; i++) {
            int a = i / 100_000;
            int b = i / 10_000 % 10;
            int c = i / 1_000 % 10;
            int d = i / 100 % 10;
            int e = i / 10 % 10;
            int f = i % 10;

            if (i < 10) check("" + f);
            if (i < 100) check("" + e + f);
            if (i < 1000) check("" + d + e + f);
            if (i < 10000) check("" + c + d + e + f);
            if (i < 100000) check("" + b + c + d + e + f);
            check("" + a + b + c + d + e + f);
        }
    }

    @Test
    void testLong() throws InterruptedException {
        int minLen = 7, maxLen = 50;
        for (int len = minLen; len <= maxLen; len++) {
            int finalLen = len;
            StressTester.constructionStressTest(
                    seed -> {
                        Random random = new Random(seed);
                        char[] arr = new char[finalLen];
                        for (int i = 0; i < finalLen; i++) arr[i] = (char) ('0' + random.nextInt(10));
                        return new String(arr);
                    },
                    Solution::findCollision,
                    SolutionTest::check,
                    1_000_000
            );
        }
    }

    private static void check(String hex) {
        assertTrue(check(hex, Solution.findCollision(hex)));
    }

    private static boolean check(String hex, String ans) {
        int n = hex.length();
        if (ans == null) return true;
        String hexString = new BigInteger(ans + hex, 10).toString(16);
        String substring = hexString.substring(Math.max(0, hexString.length() - n));
        return new BigInteger(hex).equals(new BigInteger(substring));
    }
}
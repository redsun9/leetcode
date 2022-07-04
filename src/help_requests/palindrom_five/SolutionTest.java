package help_requests.palindrom_five;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void getNumberOfPalindromesOfLengthFive() {
        assertEquals(1, new Solution().getNumberOfPalindromesOfLengthFive("10001"));
    }

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int n = 30;
        Solution solution = new Solution();
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    char[] arr = new char[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) arr[i] = (char) (random.nextInt(2) + '0');
                    return new String(arr);
                },
                SolutionTest::dummy,
                solution::getNumberOfPalindromesOfLengthFive,
                1_000_000,
                1,
                100_000
        ));
    }


    private static int dummy(String s) {
        int n = s.length();
        int ans = 0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i5 = i1 + 4; i5 < n; i5++) {
                if (s.charAt(i1) != s.charAt(i5)) continue;
                for (int i2 = i1 + 1; i2 < i5 - 2; i2++) {
                    for (int i4 = i2 + 2; i4 < i5; i4++) {
                        if (s.charAt(i2) != s.charAt(i4)) continue;
                        ans += (i4 - i2 - 1);
                    }
                }
            }
        }
        return ans;
    }
}
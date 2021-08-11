package leetcode.leetcode8xx.leetcode828;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {

    @Test
    void test1() {
        assertEquals(10, new Solution().uniqueLetterString("ABC"));
    }

    @Test
    void test2() {
        assertEquals(8, new Solution().uniqueLetterString("ABA"));
    }

    @Test
    void test3() {
        assertEquals(92, new Solution().uniqueLetterString("LEETCODE"));
    }

    @Test
    @Disabled
    void testRandom() {
        int n = 1000, testNumber = 1000;
        IntStream.range(0, testNumber).parallel().forEach(t -> {
            char[] arr = new char[n];
            Random random = ThreadLocalRandom.current();
            for (int i = 0; i < n; i++) arr[i] = (char) ('A' + random.nextInt(26));
            int[][] count = new int[n + 1][26];
            for (int i = 0; i < n; i++) {
                System.arraycopy(count[i], 0, count[i + 1], 0, 26);
                count[i + 1][arr[i] - 'A']++;
            }
            int expected = 0;
            for (int r = 1; r <= n; r++) {
                for (int l = 0; l < r; l++) {
                    for (int i = 0; i < 26; i++) {
                        if (count[r][i] - count[l][i] == 1) expected++;
                    }
                }
            }
            assertEquals(expected, new Solution().uniqueLetterString(new String(arr)));
        });
    }
}
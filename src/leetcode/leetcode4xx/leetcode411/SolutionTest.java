package leetcode.leetcode4xx.leetcode411;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import prng.XorShiftN;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        String target = "apple";
        String[] dictionary = {"blade"};
        assertEquals("a4", new Solution().minAbbreviation(target, dictionary));
    }

    @Test
    void test2() {
        String target = "apple";
        String[] dictionary = {"plain", "amber", "blade"};
        String actual = new Solution().minAbbreviation(target, dictionary);
        Set<String> expected = Set.of("1p3", "ap3", "a3e", "2p2", "3le", "3l1");
        assertTrue(expected.contains(actual));
    }

    @Test
    @Disabled
    void testRandom() {
        Solution solution = new Solution();
        int m = 21, n = 200, numberOfTests = 1_000;
        char[] arr = new char[m];
        Arrays.fill(arr, 'a');
        String target = new String(arr);
        IntStream.rangeClosed(1, numberOfTests).parallel().forEach(t -> {
            XorShiftN rnd = new XorShiftN(t, m);
            String[] dictionary = new String[n];
            char[] tmp = new char[m];
            for (int i = 0; i < n; i++) {
                int key = rnd.nextInteger();
                for (int j = 0; j < m; j++) tmp[j] = (char) ('a' + (key >> j & 1));
                dictionary[i] = new String(tmp);
            }
            String actual = solution.minAbbreviation(target, dictionary);
            assertTrue(validWordAbbreviation(target, actual));
            for (String word : dictionary) assertFalse(validWordAbbreviation(word, actual));
        });
    }


    private static boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        if (m < n) return false;

        int i = 0, j = 0;
        while (i < m && j < n) {
            char c = abbr.charAt(j++);
            if (c == '0') return false;
            else if (c >= '1' && c <= '9') {
                int count = c - '0';
                while (j < n) {
                    c = abbr.charAt(j);
                    if (c < '0' || c > '9') break;
                    count = count * 10 + c - '0';
                    j++;
                }
                if (i + count > m) return false;
                i += count;
            } else if (word.charAt(i++) != c) return false;
        }
        return i == m && j == n;
    }

}
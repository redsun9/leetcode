package microsoft.compression;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "ABBBCCDDCCC";
        assertEquals(5, new Solution().solution(s, 3));
    }

    @Test
    void test2() {
        String s = "AAAAAAAAAAABXXAAAAAAAA";
        assertEquals(3, new Solution().solution(s, 3));
    }

    @Test
    @Disabled
    void testRandom() {
        int[][] loads = {{100, 10_000}, {50, 100_000}, {20, 1_000_000}, {10, 10_000_000}};
        for (int[] load : loads) {
            int testLength = load[0];
            int testNumber = load[1];
            Pair[] tests = new Pair[testNumber];
            Solution solution = new Solution();
            IntStream.range(0, testNumber).parallel().forEach(i -> tests[i] = generateTest(testLength));
            Arrays.stream(tests).parallel().forEach(t -> {
                IntStream.range(0, testLength + 1).parallel().forEach(k -> {
                    int actual = solution.solution(t.str, k);
                    try {
                        assertEquals(t.ans[k], actual);
                    } catch (Throwable e) {
                        System.out.println(t.str);
                        System.out.println(k);
                        System.out.println(t.ans[k]);
                        System.out.println(actual);
                        throw e;
                    }
                });
            });
        }
    }

    private Pair generateTest(int testLength) {
        Random random = ThreadLocalRandom.current();
        char[] chars = new char[testLength];
        int[] ans = new int[testLength + 1];
        for (int i = 0; i < testLength; i++) {
            chars[i] = (char) ('a' + random.nextInt(3)); //a,b,c
        }
        ans[0] = comressionLength(new String(chars));
        for (int k = 1; k < testLength; k++) {
            int min = testLength;
            for (int l = 0, r = k; r <= testLength; l++, r++) {
                String testStr = new String(chars, 0, l) + new String(chars, r, testLength - r);
                min = Math.min(min, comressionLength(testStr));
            }
            ans[k] = min;
        }
        return new Pair(new String(chars), ans);
    }

    private int comressionLength(String s) {
        int n = s.length();
        int ans = 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            end = start + 1;
            char c = s.charAt(start);
            while (end != n && s.charAt(end) == c) end++;
            ans++;
            int len = end - start;
            if (len != 1) ans += 1 + (int) Math.log10(len);
            start = end;
        }
        return ans;
    }

    private static class Pair {
        String str;
        int[] ans;

        public Pair(String str, int[] ans) {
            this.str = str;
            this.ans = ans;
        }
    }
}
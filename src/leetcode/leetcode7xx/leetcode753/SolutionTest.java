package leetcode.leetcode7xx.leetcode753;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static basic.utils.IntegerUtils.binPow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] params = {{2, 20}, {3, 13}, {4, 10}, {5, 9}, {6, 8}, {7, 7}, {8, 7}, {9, 7}, {10, 6}};
        Stream.of(params).parallel().forEach(param -> {
            int k = param[0];
            IntStream.range(1, param[1] + 1).parallel().forEach(n -> {
                int total = (int) binPow(k, n);
                int largestDigit = (int) binPow(k, n - 1);
                String s = new Solution().crackSafe(n, k);
                assertEquals(total + n - 1, s.length());
                boolean[] b = new boolean[total];
                int curr = 0;
                for (int i = 0; i < n; i++) curr = curr * k + s.charAt(i) - '0';
                b[curr] = true;
                for (int i = 0, j = n; j < s.length(); i++, j++) {
                    curr = (curr - largestDigit * (s.charAt(i) - '0')) * k + s.charAt(j) - '0';
                    if (b[curr]) throw new AssertionFailedError();
                    b[curr] = true;
                }
            });
        });
    }
}
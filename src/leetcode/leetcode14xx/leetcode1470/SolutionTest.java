package leetcode.leetcode14xx.leetcode1470;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void shuffle() {
        IntStream.range(1, 1000).parallel().forEach(
                n -> {
                    int[] arr = new int[2 * n];
                    for (int i = 0; i < 2 * n; i++) {
                        arr[i] = i;
                    }
                    int[] expected = new int[2 * n];
                    for (int i = 0, j = 0, k = n; i < 2 * n; ) {
                        expected[i++] = j++;
                        expected[i++] = k++;
                    }
                    new Solution().shuffle(arr, n);
                    assertArrayEquals(expected, arr);
                }
        );
    }
}
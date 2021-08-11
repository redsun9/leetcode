package leetcode.leetcode2xx.leetcode295;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void testRight() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            for (int j = 1; j <= i; j++) {
                medianFinder.addNum(j);
            }
            assertEquals(i + 1L, Math.round(medianFinder.findMedian() * 2));
        });
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testLeft() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            for (int j = i; j >= 1; j--) {
                medianFinder.addNum(j);
            }
            assertEquals(i + 1L, Math.round(medianFinder.findMedian() * 2));
        });
    }

    @Test
    @Disabled
    void testRepeatEven() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            int n = 4 * i;
            int[] a = new int[n];
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(i);
                a[j] = num;
                medianFinder.addNum(num);
            }
            Arrays.sort(a);
            assertEquals(a[n / 2] + a[n / 2 - 1], Math.round(medianFinder.findMedian() * 2));
        });
    }

    @Test
    @Disabled
    void testRepeatOdd() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            int n = 4 * i + 1;
            int[] a = new int[n];
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(i);
                a[j] = num;
                medianFinder.addNum(num);
            }
            Arrays.sort(a);
            assertEquals(a[n / 2] * 2, Math.round(medianFinder.findMedian() * 2));
        });
    }

    @Test
    @Disabled
    void testRandomEven() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            int n = 2 * i;
            int[] a = new int[n];
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(Integer.MAX_VALUE >> 2);
                a[j] = num;
                medianFinder.addNum(num);
            }
            Arrays.sort(a);
            assertEquals(a[n / 2] + a[n / 2 - 1], Math.round(medianFinder.findMedian() * 2));
        });
    }

    @Test
    @Disabled
    void testRandomOdd() {
        IntStream.range(1, 1000).forEach(i -> {
            MedianFinder medianFinder = new MedianFinder();
            int n = 2 * i + 1;
            int[] a = new int[n];
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(Integer.MAX_VALUE >> 2);
                a[j] = num;
                medianFinder.addNum(num);
            }
            Arrays.sort(a);
            assertEquals(a[n / 2] * 2, Math.round(medianFinder.findMedian() * 2));
        });
    }


}
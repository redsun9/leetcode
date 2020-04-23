package leetcode.leetcode11xx.leetcode1116;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroEvenOddSyncTest {
    @Test
    @org.junit.jupiter.api.Disabled
    void testZeroEvenOdd() {
        IntStream.range(1, 1000).forEach(i -> {
            StringBuilder sb = new StringBuilder();
            ZeroEvenOddSync zeroEvenOddSync = new ZeroEvenOddSync(i);
            CompletableFuture<Void>[] completableFutures = new CompletableFuture[3];
            completableFutures[0] = CompletableFuture.runAsync(() -> {
                try {
                    zeroEvenOddSync.zero(x -> sb.append(' ').append(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            completableFutures[1] = CompletableFuture.runAsync(() -> {
                try {
                    zeroEvenOddSync.even(x -> sb.append(' ').append(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            completableFutures[2] = CompletableFuture.runAsync(() -> {
                try {
                    zeroEvenOddSync.odd(x -> sb.append(' ').append(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            CompletableFuture.allOf(completableFutures).join();
            String[] s = sb.toString().substring(1).split(" ");
            assertEquals(2 * i, s.length);
            for (int j = 0; j < i; j++) {
                assertEquals("0", s[2 * j]);
                assertEquals(j + 1, Integer.parseInt(s[2 * j + 1]));
            }
        });
    }
}
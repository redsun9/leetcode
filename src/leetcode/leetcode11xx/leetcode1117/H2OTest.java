package leetcode.leetcode11xx.leetcode1117;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class H2OTest {
    @Test
    @org.junit.jupiter.api.Disabled
    void test() {
        H2OAsync h2O = new H2OAsync();
        StringBuffer sb = new StringBuffer(10);
        int hydrogens = 0;
        int oxygens = 0;
        Random random = new Random();
        int n = 10000000;
        //noinspection unchecked
        CompletableFuture<Void>[] futures = new CompletableFuture[n];
        for (int i = 0; i < n; i++) {
            if (random.nextInt(3) > 0) {
                hydrogens++;
                futures[i] = CompletableFuture.runAsync(() -> {
                    try {
                        h2O.hydrogen(() -> sb.append('H'));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                oxygens++;
                futures[i] = CompletableFuture.runAsync(() -> {
                    try {
                        h2O.oxygen(() -> sb.append('O'));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        CompletableFuture.allOf(futures).join();
        String res = sb.toString();
        HashSet<String> possible = new HashSet<>();
        possible.add("HHO");
        possible.add("HOH");
        possible.add("OHH");
        int expectedH20 = Math.min(hydrogens / 2, oxygens);
        assertEquals(expectedH20 * 3, res.length());
        for (int i = 0; i < expectedH20; i++) {
            assertTrue(possible.contains(res.substring(3 * i, 3 * (i + 1))));
        }
    }
}
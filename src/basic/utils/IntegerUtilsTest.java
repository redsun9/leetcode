package basic.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.IntStream;

import static basic.utils.IntegerUtils.reverse;
import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerUtilsTest {

    @Test
    @Disabled
    void testReverse() {
        int p = 1_000_000_007;
        BigInteger bigP = valueOf(p);
        IntStream.range(1, p).parallel().forEach(i -> assertEquals(reverse(i, p), valueOf(i).modInverse(bigP).intValue()));
    }

    @Test
    void testGcd() {
        IntStream.range(0, 1_000_000_000).parallel().forEach(i -> {
            Random random = new Random();
            int a = random.nextInt(Integer.MAX_VALUE);
            int b = random.nextInt(Integer.MAX_VALUE);
            int gcd = IntegerUtils.gcd(a, b);
            int[] res = new int[3];
            IntegerUtils.gcd(a, b, res);
            assertEquals(gcd, Math.abs(res[0]));
            assertEquals(res[0], (long) a * res[1] + (long) b * res[2]);
        });
    }
}
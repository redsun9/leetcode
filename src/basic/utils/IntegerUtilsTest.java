package basic.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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
}
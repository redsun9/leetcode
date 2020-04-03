package leetcode.leetcode4xx.leetcode415;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void addStrings() {
        Solution solution = new Solution();
        Random random = new Random(0);
        for (int i = 0; i < 100000; i++) {
            BigInteger a = new BigInteger(10 + random.nextInt(1000), random);
            BigInteger b = new BigInteger(10 + random.nextInt(1000), random);
            assertEquals(a.add(b).toString(), solution.addStrings(a.toString(), b.toString()));
        }
    }
}
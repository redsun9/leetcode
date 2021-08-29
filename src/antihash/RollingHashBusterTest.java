package antihash;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RollingHashBusterTest {
    private static final int[] primes = {
            3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
            401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
            503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
            601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
            701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797,
            809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887,
            907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
    };
    private static final int[] shifts = {0, 1};

    @Test
    void testThueMorseSequence() {
        assertNotEquals(AntiRollingHash.str11, AntiRollingHash.str12);
    }

    @Test
    void testRollingHashWithOverflowHashCollision() {
        for (int shift : shifts) {
            for (int prime : primes) {
                RollingHashWithOverflow hasher = new RollingHashWithOverflow(prime, shift);
                assertEquals(hasher.hash(AntiRollingHash.str11), hasher.hash(AntiRollingHash.str12));
                assertEquals(hasher.hash(AntiRollingHash.str21), hasher.hash(AntiRollingHash.str22));
            }
        }
    }

    @Test
    void testRollingHashWithoutOverflowNoCollision() {
        for (int shift : shifts) {
            for (int prime : primes) {
                RollingHashWithoutOverflow hasher = new RollingHashWithoutOverflow(prime, shift, Integer.MAX_VALUE);
                assertNotEquals(hasher.hash(AntiRollingHash.str11), hasher.hash(AntiRollingHash.str12));
                assertNotEquals(hasher.hash(AntiRollingHash.str21), hasher.hash(AntiRollingHash.str22));
            }
        }
    }

    //  for H - number of possible hash values, it needs on average 1.1774*sqrt(H) strings to find a collision
    //  57_822 for 2^31-1
    //  1_403_916 for 2^40-87
    @Test
    @Disabled
    void testBirthdayAttackForRollingHashWithoutOverflow() {
        long[] mods = {Integer.MAX_VALUE, 1099511627689L};
        for (long mod : mods) {
            long totalAttempts = 0;
            for (int shift : shifts) {
                for (int prime : primes) {
                    RollingHashWithoutOverflow hasher = new RollingHashWithoutOverflow(prime, shift, mod);
                    String[] collisions = BirthdayAttacker.findCollisions(hasher);
                    assertNotEquals(collisions[0], collisions[1]);
                    assertEquals(collisions[0].length(), collisions[1].length());
                    assertEquals(hasher.hash(collisions[0]), hasher.hash(collisions[1]));
                    totalAttempts += Integer.parseInt(collisions[2]);
                }
            }
            System.out.println((long) Math.ceil((double) totalAttempts / shifts.length / primes.length));
        }
    }
}
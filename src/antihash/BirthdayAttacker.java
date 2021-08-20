package antihash;

import prng.XorShift32;

import java.util.HashMap;
import java.util.Map;

public class BirthdayAttacker {
    private static final int len = 32;

    public static String[] findCollisions(StringHasher hasher) {
        Map<Long, Integer> map = new HashMap<>();
        XorShift32 rnd = new XorShift32(1);
        while (true) {
            int n = rnd.nextInteger();
            long hash = hasher.hash(generateString(n));
            if (map.containsKey(hash))
                return new String[]{
                        generateString(n),
                        generateString(map.get(hash)),
                        String.valueOf(map.size() + 1)
                };
            map.put(hash, n);
        }
    }

    private static String generateString(int n) {
        char[] a = new char[len];
        for (int i = 0; i < 32; i++) a[i] = (char) ('a' + (n >>> i & 1));
        return new String(a);
    }
}

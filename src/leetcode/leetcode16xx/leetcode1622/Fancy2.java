package leetcode.leetcode16xx.leetcode1622;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fancy2 {
    private static final int MAX_INC = 100;
    private static final int p = 1_000_000_007;
    private static final BigInteger bigP = BigInteger.valueOf(p);
    private long[] reversed = new long[MAX_INC];
    private long a = 1, b = 0, revA = 1;
    private List<Long> arr = new ArrayList<>();

    public Fancy2() {
        for (int i = 0; i < MAX_INC; i++) reversed[i] = BigInteger.valueOf(i + 1).modInverse(bigP).intValue();
    }

    public void append(long val) {
        arr.add((val + p - b) * revA % p);
    }

    public void addAll(int inc) {
        b = (b + inc) % p;
    }

    public void multAll(int m) {
        a = a * m % p;
        b = b * m % p;
        revA = revA * reversed[m - 1] % p;
    }

    public int getIndex(int idx) {
        if (arr.size() <= idx) return -1;
        return (int) ((arr.get(idx) * a + b) % p);
    }
}

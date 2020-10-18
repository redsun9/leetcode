package leetcode.leetcode16xx.leetcode1622;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fancy {
    private final int p = 1_000_000_007;
    private final BigInteger bigP = BigInteger.valueOf(p);
    private final ArrayList<BigInteger> arr = new ArrayList<>();
    private BigInteger a = BigInteger.ONE;
    private BigInteger b = BigInteger.ZERO;
    private BigInteger revA = a;

    public void append(int val) {
        if (revA == null) revA = a.modInverse(bigP);
        arr.add(BigInteger.valueOf(val).add(bigP).subtract(b).multiply(revA).mod(bigP));
    }

    public void addAll(int inc) {
        b = b.add(BigInteger.valueOf(inc)).mod(bigP);
    }

    public void multAll(int m) {
        a = a.multiply(BigInteger.valueOf(m)).mod(bigP);
        b = b.multiply(BigInteger.valueOf(m).mod(bigP));
        revA = null;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return arr.get(idx).multiply(a).add(b).mod(bigP).intValue();
    }
}

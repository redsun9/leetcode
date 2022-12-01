package help_requests.collision_find;

import java.math.BigInteger;

public class Solution {
    public static String findCollision(String hex) {
        int n = hex.length();
        BigInteger hex1 = new BigInteger(hex, 10);
        BigInteger hex2 = new BigInteger(hex, 16);
        BigInteger diff = hex2.subtract(hex1);
        if (!diff.and(BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE)).equals(BigInteger.ZERO)) return null;
        diff = diff.shiftRight(n);

        BigInteger a = BigInteger.valueOf(5).pow(n);
        BigInteger b = BigInteger.valueOf(8).pow(n);
        BigInteger[] res = new BigInteger[3];
        gcd(a, b, res);
        if (res[0].signum() < 0) res[1] = res[1].negate();
        if (res[1].signum() < 0) res[1] = res[1].add(b);
        res[1] = res[1].multiply(diff);
        return res[1].toString(10);
    }


    // returns {gcd(a,b),x,y} which a*x+b*y = gcd(a,b)
    private static void gcd(BigInteger a, BigInteger b, BigInteger[] res) {
        if (a.equals(BigInteger.ZERO)) {
            res[0] = b;
            res[1] = BigInteger.ZERO;
            res[2] = BigInteger.ONE;
            return;
        }
        gcd(b.mod(a), a, res);
        BigInteger c = res[2].subtract(b.divide(a).multiply(res[1]));
        res[2] = res[1];
        res[1] = c;
    }
}

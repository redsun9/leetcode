package leetcode.leetcode972;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public boolean isRationalEqual(String s, String t) {
        BigInteger[] f1 = toFrac(s);
        BigInteger[] f2 = toFrac(t);
        return Arrays.equals(f1, f2);
    }

    private static BigInteger[] toFrac(String s) {
        int dotPos = s.indexOf('.');
        int openPos = s.indexOf('(');
        if (dotPos >= 0) {
            BigInteger a = new BigInteger(s.substring(0, dotPos));
            if (openPos >= 0) {
                BigInteger top = openPos > dotPos + 1 ? new BigInteger(s.substring(dotPos + 1, openPos)) : BigInteger.ZERO;
                BigInteger bot = BigInteger.TEN.pow(openPos - dotPos - 1);

                BigInteger pTop = new BigInteger(s.substring(openPos + 1, s.length() - 1));
                BigInteger pBot = BigInteger.TEN.pow(s.length() - openPos - 2).subtract(BigInteger.ONE)
                        .multiply(BigInteger.TEN.pow(openPos - dotPos - 1));


                BigInteger aBot = pBot.multiply(bot);
                BigInteger aTop = a.multiply(aBot).add(
                        top.multiply(pBot)
                ).add(
                        pTop.multiply(bot)
                );
                BigInteger gcd = aBot.gcd(aTop);
                aBot = aBot.divide(gcd);
                aTop = aTop.divide(gcd);
                return new BigInteger[]{aTop, aBot};
            } else {
                BigInteger top = s.length() > dotPos + 1 ? new BigInteger(s.substring(dotPos + 1)) : BigInteger.ZERO;
                BigInteger bot = BigInteger.TEN.pow(s.length() - dotPos - 1);
                BigInteger gcd = bot.gcd(top);
                top = top.divide(gcd);
                bot = bot.divide(gcd);
                top = a.multiply(bot).add(top);
                return new BigInteger[]{top, bot};
            }
        } else {
            return new BigInteger[]{new BigInteger(s), BigInteger.ONE};
        }
    }
}

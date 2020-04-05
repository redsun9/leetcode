package leetcode.leetcode14xx.leetcode1404;

import java.math.BigInteger;

public class Solution {
    public int numSteps(String s) {
        BigInteger a = new BigInteger(s, 2);
        int ans = 0;
        while (!a.equals(BigInteger.ONE)) {
            if (a.testBit(0)) {
                a = a.add(BigInteger.ONE);
            } else {
                a = a.shiftRight(1);
            }
            ans++;
        }
        return ans;
    }
}

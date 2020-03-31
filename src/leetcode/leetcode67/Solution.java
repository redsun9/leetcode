package leetcode.leetcode67;

import java.math.BigInteger;

public class Solution {
    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
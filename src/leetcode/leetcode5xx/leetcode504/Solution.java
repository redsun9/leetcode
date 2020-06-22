package leetcode.leetcode5xx.leetcode504;

import java.math.BigInteger;

public class Solution {
    public String convertToBase7(int num) {
        return BigInteger.valueOf(num).toString(7);
    }
}

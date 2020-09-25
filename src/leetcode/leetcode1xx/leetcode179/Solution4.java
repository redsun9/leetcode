package leetcode.leetcode1xx.leetcode179;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Solution4 {

    public String largestNumber(int[] nums) {
        // finding number of digits in maximum element
        // present in array
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int n = Integer.toString(max).length();

        ArrayList<ExtendedNum> en =
                new ArrayList<ExtendedNum>();
        for (int num : nums) en.add(new ExtendedNum(num, n));

        // sort based on modified value
        Collections.sort(en, (p1, p2) ->
                (int) (p2.modifiedValue - p1.modifiedValue));

        StringBuilder sb = new StringBuilder();
        for (ExtendedNum extendedNum : en) sb.append(Long.toString(extendedNum.originalValue));

        // To remove any zeroes at head.
        BigInteger bi = new BigInteger(sb.toString());

        return bi.toString();
    }


    private static class ExtendedNum {
        int originalValue;
        long modifiedValue;

        public ExtendedNum(int originalValue, int n) {
            this.originalValue = originalValue;
            String s = Integer.toString(originalValue);
            StringBuilder sb = new StringBuilder(s);
            StringBuilder ans = new StringBuilder();
            while (ans.length() <= n + 1)
                ans.append(sb);

            s = ans.substring(0, n + 1);
            modifiedValue = Long.parseLong(s);
        }

        public String toString() {
            return "[" + modifiedValue +
                    ", " + originalValue + "]";
        }
    }
}

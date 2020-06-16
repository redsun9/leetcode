package leetcode.leetcode8xx.leetcode899;

import java.util.Arrays;

public class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k > 1) {
            Arrays.sort(chars);
            return new String(chars);
        } else {
            int length = s.length();
            char[] ds = new char[2 * length];
            System.arraycopy(chars, 0, ds, 0, length);
            System.arraycopy(chars, 0, ds, length, length);
            int maxIndex = 0;
            for (int i = 1; i < length; i++) {
                if (isHigher(ds, maxIndex, i, length)) maxIndex = i;
            }
            return new String(ds, maxIndex, length);
        }
    }

    private static boolean isHigher(final char[] chars, final int i1, final int i2, final int length) {
        for (int i = i1, j = i2; i < i1 + length; i++, j++) {
            if (chars[i] != chars[j]) return chars[i] > chars[j];
        }
        return false;
    }
}

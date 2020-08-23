package leetcode.leetcode15xx.leetcode1556;

import java.text.NumberFormat;
import java.util.Locale;

public class Solution {
    public String thousandSeparator(int n) {
        NumberFormat format = NumberFormat.getIntegerInstance(Locale.GERMAN);
        return format.format(n);
    }
}

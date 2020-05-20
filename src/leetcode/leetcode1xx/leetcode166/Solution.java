package leetcode.leetcode1xx.leetcode166;

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (Long.signum(numerator) * Long.signum(denominator) < 1) sb.append('-');
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        sb.append(numerator / denominator);
        numerator %= denominator;
        if (numerator != 0) {
            sb.append(".");
            if (denominator < 10000) {
                int[] mods = new int[(int) denominator];
                mods[(int) numerator] = 1;
                int i = 2;
                while (true) {
                    sb.append(numerator * 10 / denominator);
                    numerator = numerator * 10 % denominator;
                    if (numerator == 0) break;
                    if (mods[(int) numerator] != 0) {
                        sb.insert(sb.length() - i + mods[(int) numerator], '(');
                        sb.append(')');
                        break;
                    } else {
                        mods[(int) numerator] = i;
                    }
                    i++;
                }
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put((int) numerator, 1);
                int i = 2;
                while (true) {
                    sb.append(numerator * 10 / denominator);
                    numerator = numerator * 10 % denominator;
                    if (numerator == 0) break;
                    if (map.containsKey((int) numerator)) {
                        sb.insert(sb.length() - i + map.get((int) numerator), '(');
                        sb.append(')');
                        break;
                    } else {
                        map.put((int) numerator, i);
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }
}

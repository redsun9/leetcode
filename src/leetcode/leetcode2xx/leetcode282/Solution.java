package leetcode.leetcode2xx.leetcode282;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] operators = {'-', '+', '*'};

    private static String generateString(int[] digits, int n, int mask) {
        int numberOfOperators = Integer.bitCount(0x55555555 & (mask | mask >> 1));
        char[] ans = new char[n + numberOfOperators];
        ans[0] = (char) ('0' + digits[0]);
        for (int i = 1, pos = 1; i < n; i++, mask >>>= 2) {
            int symbol = mask & 3;
            if (symbol != 0) ans[pos++] = operators[symbol - 1];
            ans[pos++] = (char) ('0' + digits[i]);
        }
        return new String(ans);
    }

    public List<String> addOperators(String num, int target) {
        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = num.charAt(i) - '0';
        long[] rightMax = new long[n];
        long weight = 1, currRightMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            currRightMax += weight * digits[i];
            weight *= 10L;
            rightMax[i] = currRightMax;
        }
        List<String> ans = new ArrayList<>();
        int totalVariants = 1 << (2 * (n - 1));
        for (int mask = 0; mask < totalVariants; mask++) {
            int tmpMask = mask;
            boolean ok = true;
            long sum = 0;
            long currMultiplier = 1;
            long currOperand = digits[0];
            for (int i = 1; ok && i <= n; i++, tmpMask >>>= 2) {
                if (i == n) {
                    sum += currMultiplier * currOperand;
                    continue;
                }
                int symbol = tmpMask & 3;
                switch (symbol) {
                    case 0 -> {
                        // no operator
                        if (currOperand == 0) ok = false;
                        else currOperand = currOperand * 10 + digits[i];
                    }
                    case 1, 2 -> {
                        // minus, plus
                        sum += currMultiplier * currOperand;
                        if (rightMax[i] < Math.abs(sum - target)) ok = false;
                        currMultiplier = -3 + symbol * 2;
                        currOperand = digits[i];
                    }
                    case 3 -> {
                        // asterisk
                        currMultiplier *= currOperand;
                        currOperand = digits[i];
                    }
                }
            }
            if (ok && sum == target) {
                ans.add(generateString(digits, n, mask));
            }
        }
        return ans;
    }
}

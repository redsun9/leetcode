package leetcode.leetcode8xx.leetcode831;

import java.util.Arrays;

@SuppressWarnings("StringRepeatCanBeUsed")
public class Solution {
    public String maskPII(String s) {
        char c = s.charAt(s.length() - 1);
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' ? maskEmail(s) : maskPhone(s);
    }

    private static String maskEmail(String s) {
        int diff = 'a' - 'A';
        int n = s.length();
        int pos = s.indexOf('@');
        char[] ans = new char[7 + n - pos];
        ans[0] = s.charAt(0);
        Arrays.fill(ans, 1, 6, '*');
        ans[6] = s.charAt(pos - 1);
        ans[7] = '@';
        pos++;
        for (int i = 8; pos < n; i++, pos++) ans[i] = s.charAt(pos);
        for (int i = 0; i < ans.length; i++) if (ans[i] >= 'A' && ans[i] <= 'Z') ans[i] += diff;
        return new String(ans);
    }

    @SuppressWarnings("StringConcatenationInLoop")
    private static String maskPhone(String s) {
        String ans = "";
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (++len <= 4) ans = c + ans;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (len > 10) sb.append('+');
        for (int i = 0; i < len - 10; i++) sb.append('*');
        if (len > 10) sb.append('-');
        sb.append("***-***-");
        sb.append(ans);
        return sb.toString();
    }
}

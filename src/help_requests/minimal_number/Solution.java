package help_requests.minimal_number;

import java.util.Arrays;

public class Solution {
    public static String minimalNumber(String s) {
        int n = s.length();
        if (n <= 1) return s;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) count[s.charAt(i) - '0']++;

        char[] ans = new char[n];
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 0) {
                ans[0] = (char) ('0' + i);
                count[i]--;
                break;
            }
        }
        int pos = 1;
        for (int i = 0; i <= 9; i++) {
            Arrays.fill(ans, pos, pos + count[i], (char) ('0' + i));
            pos += count[i];
        }
        return new String(ans);
    }
}

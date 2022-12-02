package help_requests.new_order;

import java.util.Arrays;

public class Solution {
    public static String[] sortWithNewAlphabetOrder(String[] strings, String x) {
        int[] charToIndex = new int[26];
        for (int i = 0; i < 26; i++) charToIndex[x.charAt(i) - 'a'] = i;
        Arrays.sort(strings, (a, b) -> compare(a, b, charToIndex));
        return strings;
    }

    private static int compare(String a, String b, int[] charToIndex) {
        int m = a.length(), n = b.length(), min = Math.min(m, n);
        for (int i = 0; i < min; i++) {
            int c1 = charToIndex[a.charAt(i) - 'a'];
            int c2 = charToIndex[b.charAt(i) - 'a'];
            if (c1 != c2) return c1 - c2;
        }
        return m - n;
    }
}

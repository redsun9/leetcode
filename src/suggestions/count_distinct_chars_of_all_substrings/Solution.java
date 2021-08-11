package suggestions.count_distinct_chars_of_all_substrings;

import java.util.Arrays;

public class Solution {
    public int distinctLetterString(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int ans = 0, sum = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            sum = sum - last[c] + i;
            last[c] = i;
            ans += sum;
        }
        return ans;
    }
}

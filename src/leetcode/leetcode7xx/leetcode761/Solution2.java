package leetcode.leetcode7xx.leetcode761;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//recursive solution

public class Solution2 {
    public String makeLargestSpecial(String s) {
        return makeLargestSpecial(s, 0, s.length());
    }

    private static String makeLargestSpecial(String s, int start, int end) {
        int count = 0, left = start;
        List<String> parts = new ArrayList<>();
        for (int right = start; right < end; right++) {
            if (s.charAt(right) == '1') count++;
            else if (--count == 0) {
                parts.add('1' + makeLargestSpecial(s, left + 1, right) + '0');
                left = right + 1;
            }
        }
        parts.sort(Comparator.reverseOrder());
        return String.join("", parts);
    }
}

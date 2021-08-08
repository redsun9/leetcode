package leetcode.leetcode9xx.leetcode929;

import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            char[] s = email.toCharArray();
            int i = 0, j = 0, n = s.length;
            boolean afterPlus = false;
            while (j < n && s[j] != '@') {
                if (!afterPlus && s[j] >= 'a' && s[j] <= 'z') s[i++] = s[j];
                afterPlus |= s[j] == '+';
                j++;
            }
            System.arraycopy(s, j, s, i, n - j);
            set.add(new String(s, 0, i + n - j));
        }
        return set.size();
    }
}

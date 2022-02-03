package leetcode.leetcode21xx.leetcode2135;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for (String s : startWords) {
            int mask = 0, len = s.length();
            for (int i = 0; i < len; i++) mask |= 1 << (s.charAt(i) - 'a');
            set.add(mask);
        }
        int ans = 0;
        for (String s : targetWords) {
            int mask = 0, len = s.length();
            for (int i = 0; i < len; i++) mask |= 1 << (s.charAt(i) - 'a');
            boolean found = false;
            for (int i = 0; !found && i < len; i++) found = set.contains(mask ^ (1 << (s.charAt(i) - 'a')));
            if (found) ans++;
        }
        return ans;
    }
}

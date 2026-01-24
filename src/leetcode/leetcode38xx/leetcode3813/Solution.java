package leetcode.leetcode38xx.leetcode3813;

import java.util.Set;

public class Solution {
    public int vowelConsonantScore(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = s.length();
        int v = 0, c = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (vowels.contains(ch)) v++;
                else c++;
            }
        }
        return c == 0 ? 0 : v / c;
    }
}

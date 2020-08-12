package leetcode.leetcode3xx.leetcode345;

import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int lo = 0;
        int hi = s.length() - 1;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while (lo < hi) {
            while (lo < hi && !vowels.contains(chars[lo])) lo++;
            while (lo < hi && !vowels.contains(chars[hi])) hi--;
            char tmp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = tmp;
            lo++;
            hi--;
        }
        return new String(chars);
    }
}

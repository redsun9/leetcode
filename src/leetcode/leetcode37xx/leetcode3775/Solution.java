package leetcode.leetcode37xx.leetcode3775;

import java.util.Set;

public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int i = 0, firstWordVowelCount = 0, n = chars.length;
        while (i < n && chars[i] != ' ') {
            if (vowels.contains(chars[i])) firstWordVowelCount++;
            i++;
        }

        for (int l = i + 1, r = i + 1, cntVowel = 0; r < n; ) {
            if (vowels.contains(chars[r])) cntVowel++;
            if (r + 1 == n || chars[r + 1] == ' ') {
                if (cntVowel == firstWordVowelCount) mirror(chars, l, r);
                cntVowel = 0;
                l = r + 2;
                r = r + 2;
            } else ++r;
        }
        return new String(chars);
    }

    private static void mirror(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            ++start;
            --end;
        }
    }
}

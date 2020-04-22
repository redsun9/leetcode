package leetcode.leetcode7xx.leetcode784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int[] positions = new int[12];
        int numberOfLetters = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 32;
                positions[numberOfLetters++] = i;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                positions[numberOfLetters++] = i;
            }
        }
        int resultSize = 1 << numberOfLetters;
        ArrayList<String> ans = new ArrayList<>(resultSize);
        for (int i = 0; i < resultSize; i++) {
            for (int j = 0; j < numberOfLetters; j++) {
                chars[positions[j]] -= ((i >> j) & 1) * 32;
            }
            ans.add(new String(chars));
            for (int j = 0; j < numberOfLetters; j++) {
                chars[positions[j]] += ((i >> j) & 1) * 32;
            }
        }
        return ans;
    }
}

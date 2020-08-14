package leetcode.leetcode8xx.leetcode804;

import java.util.HashSet;

public class Solution {
    //len of char
    public static final int[] len = {2, 4, 4, 3, 1, 4, 3, 4, 2, 4, 3, 4, 2, 2, 3, 4, 4, 3, 3, 1, 3, 4, 3, 4, 4, 4};
    private static final String[] morze = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    //integer produced after replacing all dots to 1 and dashes to 0
    private static final int[] val = {2, 7, 5, 3, 1, 13, 1, 15, 3, 8, 2, 11, 0, 1, 0, 9, 2, 5, 7, 0, 6, 14, 4, 6, 4, 3};


    public int uniqueMorseRepresentations(String[] words) {
        HashSet<Long> set = new HashSet<>();
        for (String word : words) {
            long a = 1;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                a = (a << len[c]) | val[c];
            }
            set.add(a);
        }
        return set.size();
    }
}

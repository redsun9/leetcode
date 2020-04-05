package leetcode.leetcode13xx.leetcode1307;

import java.util.HashMap;

public class Solution {
    public boolean isSolvable(String[] words, String result) {
        if (words.length == 1) return result.equals(words[0]);
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] cantBeZero = new boolean[10];
        int differentCharacters = 0;
        int[][] digits = new int[words.length][];
        int maxWordLength = 0;
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int length = chars.length;
            maxWordLength = Math.max(maxWordLength, length);
            int[] digit = new int[length];
            digits[i] = digit;
            for (int j = 0; j < length; j++) {
                if (map.containsKey(chars[j])) {
                    digit[j] = map.get(chars[j]);
                } else {
                    map.put(chars[j], differentCharacters);
                    digit[j] = differentCharacters;
                    differentCharacters++;
                }
            }
            if (length > 1) cantBeZero[digit[0]] = true;
        }
        int resultLength = result.length();
        if (maxWordLength > resultLength || maxWordLength + 1 < resultLength) return false;
        int[] resultDigits = new int[resultLength];
        char[] resultChars = result.toCharArray();
        for (int i = resultLength - 1, j = 0; i >= 0; i--, j++) {
            if (map.containsKey(resultChars[i])) {
                resultDigits[j] = map.get(resultChars[i]);
            } else {
                map.put(resultChars[i], differentCharacters);
                resultDigits[j] = differentCharacters;
                differentCharacters++;
            }
        }
        if (resultLength > 1) cantBeZero[resultDigits[resultLength - 1]] = true;

        int[][] sumDigits = new int[maxWordLength][differentCharacters];
        for (int[] digit : digits) {
            for (int i = digit.length - 1, j = 0; i >= 0; i--, j++) {
                sumDigits[j][digit[i]]++;
            }
        }
        return backtrack(
                sumDigits, resultDigits, cantBeZero, differentCharacters,
                0, new int[differentCharacters], new boolean[10]
        );
    }


    private static boolean backtrack(
            int[][] sumDigits, int[] resDigits, boolean[] cantBeZero,
            int differentCharacters, int i, int[] tmp, boolean[] used
    ) {
        if (i == differentCharacters) return check(sumDigits, resDigits, tmp);
        for (int j = cantBeZero[i] ? 1 : 0; j <= 9; j++) {
            if (!used[j]) {
                used[j] = true;
                tmp[i] = j;
                if (backtrack(sumDigits, resDigits, cantBeZero, differentCharacters, i + 1, tmp, used)) {
                    return true;
                }
                used[j] = false;
            }
        }
        return false;
    }

    private static boolean check(int[][] sumDigits, int[] resDigits, int[] tmp) {
        int d = 0;
        for (int i = 0; i < sumDigits.length; i++) {
            for (int j = 0; j < sumDigits[i].length; j++) {
                d += sumDigits[i][j] * tmp[j];
            }
            if (d % 10 != tmp[resDigits[i]]) return false;
            d /= 10;
        }
        if (sumDigits.length == resDigits.length) return d == 0;
        return d == tmp[resDigits[resDigits.length - 1]];
    }
}

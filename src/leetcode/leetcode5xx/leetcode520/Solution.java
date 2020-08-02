package leetcode.leetcode5xx.leetcode520;

public class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n <= 1) return true;
        boolean firstCapital = Character.isUpperCase(word.charAt(0));
        boolean secondCapital = Character.isUpperCase(word.charAt(1));
        return !firstCapital && allNoneCapitals(word) ||
                firstCapital && (
                        secondCapital && allCapitals(word) ||
                                !secondCapital && allNoneCapitals(word)
                );
    }

    private static boolean allCapitals(String word) {
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) return false;
        }
        return true;
    }

    private static boolean allNoneCapitals(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
}

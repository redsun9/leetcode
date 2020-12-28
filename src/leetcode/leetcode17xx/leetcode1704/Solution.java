package leetcode.leetcode17xx.leetcode1704;

public class Solution {
    char[] vowels = {'a', 'e', 'o', 'i', 'u'};

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count1 = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            char c = Character.toLowerCase(s.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (vowels[j] == c) {
                    count1++;
                    break;
                }
            }
        }
        int count2 = 0;
        for (int i = n / 2; i < n; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (vowels[j] == c) {
                    count2++;
                    break;
                }
            }
        }
        return count1 == count2;
    }
}

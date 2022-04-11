package leetcode.leetcode4xx.leetcode420;

public class Solution {
    public int strongPasswordChecker(String password) {
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        char[] s = password.toCharArray();
        int n = s.length;
        for (char c : s) {
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
        }

        int missingClass = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);
        if (n < 6) {
            int maxRepeatingLen = 0;
            for (int i = 0, l = 1; i < n; i++, l++) {
                if (i == n - 1 || s[i] != s[i + 1]) {
                    maxRepeatingLen = Math.max(maxRepeatingLen, l);
                    l = 0;
                }
            }
            int minFixRepeating = switch (maxRepeatingLen) {
                case 5 -> 2;
                case 4, 3 -> 1;
                default -> 0;
            };
            return max(6 - n, missingClass, minFixRepeating);
        } else if (n <= 20) {
            int minFixRepeating = 0;
            for (int i = 0, l = 1; i < n; i++, l++) {
                if (i == n - 1 || s[i] != s[i + 1]) {
                    minFixRepeating += l / 3;
                    l = 0;
                }
            }
            return max(missingClass, minFixRepeating);
        } else {
            int mod0 = 0, mod1 = 0, minChange = 0;
            for (int i = 0, l = 1; i < n; i++, l++) {
                if (i == n - 1 || s[i] != s[i + 1]) {
                    if (l >= 3) {
                        minChange += l / 3;
                        switch (l % 3) {
                            case 0 -> mod0++;
                            case 1 -> mod1++;
                        }
                    }
                    l = 0;
                }
            }
            int shouldBeRemoved = n - 20;

            int usedMod0 = Math.min(mod0, shouldBeRemoved);
            shouldBeRemoved -= usedMod0;
            minChange -= usedMod0;

            int usedMod1 = Math.min(mod1, shouldBeRemoved / 2);
            shouldBeRemoved -= 2 * usedMod1;
            minChange -= usedMod1;

            int usedMod2 = Math.min(minChange, shouldBeRemoved / 3);
            shouldBeRemoved -= 3 * usedMod2;
            minChange -= usedMod2;
            return usedMod0 + 2 * usedMod1 + 3 * usedMod2 + shouldBeRemoved + Math.max(minChange, missingClass);
        }
    }

    private static int max(int a, int b) {
        return Math.max(a, b);
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}


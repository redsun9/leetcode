package leetcode.leetcode4xx.leetcode411;

public class Solution2 {
    /**
     * @param target:     a target string
     * @param dictionary: a set of strings in a dictionary
     * @return an abbreviation of the target string with the smallest possible length
     */
    public String minAbbreviation(String target, String[] dictionary) {
        int n = dictionary.length;
        int m = target.length();
        int[] masks = new int[n];

        int totalMask = 0;
        boolean hasWordOfSameLength = false;

        for (int i = 0; i < n; i++) {
            String s = dictionary[i];
            if (s.length() != m) continue;
            hasWordOfSameLength = true;
            int mask = 0;
            for (int j = 0; j < m; j++) if (target.charAt(j) != s.charAt(j)) mask |= 1 << j;
            masks[i] = mask;
            totalMask |= mask;
        }

        if (!hasWordOfSameLength) return Integer.toString(m);

        int ans = (1 << m) - 1, ansLength = m;
        int subMask = totalMask;
        while (subMask != 0) {
            int tmp = lengthOfAbbreviation(m, subMask);
            if (tmp < ansLength && check(masks, subMask)) {
                ans = subMask;
                ansLength = tmp;
            }
            subMask = (subMask - 1) & totalMask;
        }

        return generateAbbreviation(target, ans);
    }

    private static boolean check(int[] masks, int subMask) {
        for (int mask : masks) if (mask != 0 && (mask & subMask) == 0) return false;
        return true;
    }

    private static int lengthOfAbbreviation(int m, int key) {
        int pos = 0, left = 0, right = 0;
        while (right <= m) {
            if (right == m || (key >>> right & 1) == 1) {
                if (left != right) {
                    int k = right - left;
                    while (k != 0) {
                        pos++;
                        k /= 10;
                    }
                }
                if (right != m) pos++;
                left = right + 1;
            }
            right++;
        }
        return pos;
    }

    private static String generateAbbreviation(String word, int key) {
        int m = word.length();
        char[] tmp = new char[m];
        int pos = 0, left = 0, right = 0;
        while (right <= m) {
            if (right == m || (key >>> right & 1) == 1) {
                if (left != right) {
                    int k = right - left;
                    int d = 0;
                    while (k != 0) {
                        tmp[pos++] = (char) ('0' + k % 10);
                        d++;
                        k /= 10;
                    }
                    if (d != 1) {
                        for (int i = pos - d, j = pos - 1; i < j; i++, j--) {
                            char t = tmp[i];
                            tmp[i] = tmp[j];
                            tmp[j] = t;
                        }
                    }
                }
                if (right != m) tmp[pos++] = word.charAt(right);
                left = right + 1;
            }
            right++;
        }
        return new String(tmp, 0, pos);
    }
}

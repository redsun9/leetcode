package leetcode.leetcode15xx.leetcode1573;

public class Solution {
    public static final int p = 1_000_000_007;

    public int numWays(String s) {
        int n = s.length();
        if (n < 3) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') count++;
        if (count % 3 != 0) return 0;
        if (count == 0) return (int) ((n - 1L) * (n - 2) / 2 % p);
        count /= 3;

        int firstStart = -1;
        int tmp = count;
        while (tmp > 0) if (s.charAt(++firstStart) == '1') tmp--; // firstStart - position of count-th 'a'
        int firstEnd = firstStart + 1;
        while (s.charAt(firstEnd) != '1') firstEnd++;

        int thirdStart = n;
        tmp = count;
        while (tmp > 0) if (s.charAt(--thirdStart) == '1') tmp--; // thirdStart - position of count-th 'a'
        int thirdEnd = thirdStart - 1;
        while (s.charAt(thirdEnd) != '1') thirdEnd--;

        return (int) (((long) firstEnd - firstStart) * (thirdStart - thirdEnd) % p);
    }
}

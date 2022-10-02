package leetcode.leetcode24xx.leetcode2423;

public class Solution {
    public boolean equalFrequency(String s) {
        int n = s.length();
        if (n <= 3) return true;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

        int max = 0;
        for (int c : count) max = Math.max(max, c);
        if (max == 1) return true;

        int countMax = 0, countMaxMinusOne = 0, countOne = 0;
        for (int c : count) {
            if (c == max) countMax++;
            else if (c == max - 1) countMaxMinusOne++;
            if (c == 1) countOne++;
        }
        if (max > 2) {
            //there is letter with count not int(1, max-1, max)
            if (countMax * max + countMaxMinusOne * (max - 1) + countOne != n) return false;

            // countMaxMinusOne==0, and countOne=1 => remove letter with count 1
            if (countMaxMinusOne == 0 && countOne == 1) return true;

            // countMax = 1, countOne = 0 => remove letter with count = countMax
            return countMax == 1 && countOne == 0;
        } else {
            //max == 2
            return countOne == 1 || countMax == 1;
        }
    }
}

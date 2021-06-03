package leetcode.leetcode13xx.leetcode1360;

public class Solution {
    private static final int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    private static int daysFrom1970Year(String S) {
        int y = extractYear(S);
        int m = extractMonth(S);
        int d = extractDay(S);
        for (int i = 1971; i < y; i++) d += isLeap(i) ? 366 : 365;
        d += days[m - 1];
        if (m > 2 && isLeap(y)) d++;
        return d;

    }

    private static boolean isLeap(int y) {
        return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
    }

    private static int extractYear(String s) {
        return (s.charAt(0) - '0') * 1000
                + (s.charAt(1) - '0') * 100
                + (s.charAt(2) - '0') * 10
                + (s.charAt(3) - '0');
    }

    private static int extractMonth(String s) {
        return (s.charAt(5) - '0') * 10
                + (s.charAt(6) - '0');
    }

    private static int extractDay(String s) {
        return (s.charAt(8) - '0') * 10
                + (s.charAt(9) - '0');
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1970Year(date1) - daysFrom1970Year(date2));
    }
}

package leetcode.leetcode11xx.leetcode1154;

public class Solution {
    private static int[] a = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int ans = a[month - 1] + day;
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ans++;
        return ans;
    }
}

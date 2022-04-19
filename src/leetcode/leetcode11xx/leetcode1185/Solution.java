package leetcode.leetcode11xx.leetcode1185;

public class Solution {
    private static final String[] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] daysInMonthMod7 = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

    public String dayOfTheWeek(int day, int month, int year) {
        if (month < 3) year -= 1; // 3
        return daysInWeek[(year + (year / 4 - year / 100 + year / 400) + daysInMonthMod7[month - 1] + day) % 7];
    }
}

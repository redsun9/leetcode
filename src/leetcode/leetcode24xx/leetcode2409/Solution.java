package leetcode.leetcode24xx.leetcode2409;

public class Solution {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = dayOfTheYear(getInt(arriveAlice.charAt(0), arriveAlice.charAt(1)), getInt(arriveAlice.charAt(3), arriveAlice.charAt(4)));
        int b = dayOfTheYear(getInt(leaveAlice.charAt(0), leaveAlice.charAt(1)), getInt(leaveAlice.charAt(3), leaveAlice.charAt(4)));
        int c = dayOfTheYear(getInt(arriveBob.charAt(0), arriveBob.charAt(1)), getInt(arriveBob.charAt(3), arriveBob.charAt(4)));
        int d = dayOfTheYear(getInt(leaveBob.charAt(0), leaveBob.charAt(1)), getInt(leaveBob.charAt(3), leaveBob.charAt(4)));
        return Math.max(0, Math.min(b, d) - Math.max(a, c) + 1);
    }

    private static int getInt(char a, char b) {
        return (a - '0') * 10 + b - '0';
    }

    private static int dayOfTheYear(int month, int day) {
        int ans = day;
        for (int i = 1; i < month; i++) ans += days[i - 1];
        return ans;
    }
}

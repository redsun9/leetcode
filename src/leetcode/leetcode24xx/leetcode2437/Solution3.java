package leetcode.leetcode24xx.leetcode2437;

public class Solution3 {
    public int countTime(String time) {
        int hours;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') hours = 24;
            else if (time.charAt(1) <= '3') hours = 3;
            else hours = 2;
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) <= '1') hours = 10;
            else if (time.charAt(0) == 2) hours = 4;
            else return 0;
        } else if ((time.charAt(0) - '0') * 10 + time.charAt(1) - '0' >= 24) return 0;
        else hours = 1;

        int minutes = time.charAt(4) == '?' ? 10 : 1;

        if (time.charAt(3) == '?') minutes *= 6;
        else if (time.charAt(3) >= '6') return 0;

        return hours * minutes;
    }
}

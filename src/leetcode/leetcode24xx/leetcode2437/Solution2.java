package leetcode.leetcode24xx.leetcode2437;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public int countTime(String time) {
        int hours = 0;
        for (int a = 0; a <= 2; a++) {
            if (time.charAt(0) != '?' && time.charAt(0) != '0' + a) continue;
            for (int b = 0; b <= 9; b++) {
                if (time.charAt(1) != '?' && time.charAt(1) != '0' + b) continue;
                if (a * 10 + b >= 24) continue;
                hours++;
            }
        }
        int minutes = 0;
        for (int c = 0; c <= 5; c++) {
            if (time.charAt(3) != '?' && time.charAt(3) != '0' + c) continue;
            for (int d = 0; d <= 9; d++) {
                if (time.charAt(4) != '?' && time.charAt(4) != '0' + d) continue;
                minutes++;
            }
        }
        return hours * minutes;
    }
}

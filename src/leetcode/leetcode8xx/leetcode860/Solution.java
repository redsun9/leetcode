package leetcode.leetcode8xx.leetcode860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a = 0, b = 0, c = 0;
        for (int bill : bills) {
            if (bill == 5) {
                a++;
            } else if (bill == 10) {
                b++;
                if (a-- == 0) return false;
            } else {
                c++;
                if (b > 0 && a > 0) {
                    b--;
                    a--;
                } else if (a >= 3) {
                    a -= 3;
                } else return false;
            }
        }
        return true;
    }
}

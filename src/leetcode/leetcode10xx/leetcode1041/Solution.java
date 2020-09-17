package leetcode.leetcode10xx.leetcode1041;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int moveX = 1, moveY = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        int tmp;
        for (int i = 0; i < n; i++) {
            switch (instructions.charAt(i)) {
                case 'G' -> {
                    x += moveX;
                    y += moveY;
                }
                case 'L' -> {
                    tmp = moveX;
                    moveX = -moveY;
                    moveY = tmp;
                }
                case 'R' -> {
                    tmp = moveY;
                    moveY = -moveX;
                    moveX = tmp;
                }
            }
        }
        return (x == 0 && y == 0) || moveX != 1 || moveY != 0;
    }
}

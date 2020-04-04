package leetcode.leetcode14xx.leetcode1401;

public class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int p_X = x_center >= x2 ? x2 : x_center <= x1 ? x1 : x_center;
        int p_Y = y_center >= y2 ? y2 : y_center <= y1 ? y1 : y_center;
        return (p_X - x_center) * (p_X - x_center) + (p_Y - y_center) * (p_Y - y_center) <= radius * radius;
    }
}

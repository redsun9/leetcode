package sbercraft;

public class Solution3 {
    public static int brokenDevice(int x, int y) {
        int ans = 0;
        while (y > x) {
            if (y % 2 != 0) y += 1;
            else y /= 2;
            ans += 1;
        }
        return ans + x - y;
    }
}

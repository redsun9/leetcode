package leetcode.leetcode22xx.leetcode2211;

public class Solution {
    public int countCollisions(String directions) {
        int n = directions.length(), ans = 0;
        boolean hasLeftCollision = false;
        for (int i = 0, r = 0; i < n; i++) {
            switch (directions.charAt(i)) {
                case 'L' -> {
                    if (r != 0 || hasLeftCollision) ans += r + 1;
                    r = 0;
                }
                case 'S' -> {
                    ans += r;
                    r = 0;
                    hasLeftCollision = true;
                }
                case 'R' -> {
                    r++;
                    hasLeftCollision = true;
                }
            }
        }
        return ans;
    }
}

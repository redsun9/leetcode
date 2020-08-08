package leetcode.leetcode8xx.leetcode874;

import java.util.HashSet;
import java.util.Objects;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Pair> set = new HashSet<>();
        for (int[] obstacle : obstacles) set.add(new Pair(obstacle[0], obstacle[1]));
        int x = 0, y = 0, dx = 0, dy = 1, ans = 0;
        for (int command : commands) {
            if (command > 0) {
                while (command-- > 0 && !set.contains(new Pair(x + dx, y + dy))) {
                    x += dx;
                    y += dy;
                }
                ans = Math.max(ans, x * x + y * y);
            } else if (command == -1) {
                int newDx = dy;
                int newDy = -dx;
                dx = newDx;
                dy = newDy;
            } else {
                int newDx = -dy;
                int newDy = dx;
                dx = newDx;
                dy = newDy;
            }
        }
        return ans;
    }

    private static final class Pair {
        int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

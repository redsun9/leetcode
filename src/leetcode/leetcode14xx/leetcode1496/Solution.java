package leetcode.leetcode14xx.leetcode1496;

import java.util.HashSet;
import java.util.Objects;

public class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        if (n <= 1) return false;
        HashSet<Pair> visitedSet = new HashSet<>();
        visitedSet.add(new Pair(0, 0));
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            switch (path.charAt(i)) {
                case 'N' -> x++;
                case 'S' -> x--;
                case 'E' -> y++;
                case 'W' -> y--;
            }
            if (!visitedSet.add(new Pair(x, y))) return true;
        }
        return false;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

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
    }
}

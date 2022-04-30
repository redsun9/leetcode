package leetcode.leetcode22xx.leetcode2257;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        TreeSet<Point> guardsByX = new TreeSet<>(Comparator.<Point>comparingInt(p -> p.x).thenComparingInt(p -> p.y));
        TreeSet<Point> guardsByY = new TreeSet<>(Comparator.<Point>comparingInt(p -> p.y).thenComparingInt(p -> p.x));
        TreeSet<Point> wallsByX = new TreeSet<>(Comparator.<Point>comparingInt(p -> p.x).thenComparingInt(p -> p.y));
        TreeSet<Point> wallsByY = new TreeSet<>(Comparator.<Point>comparingInt(p -> p.y).thenComparingInt(p -> p.x));
        HashSet<Point> occupied = new HashSet<>();
        for (int[] guard : guards) {
            Point point = new Point(guard[0], guard[1]);
            guardsByX.add(point);
            guardsByY.add(point);
            occupied.add(point);
        }
        for (int[] wall : walls) {
            Point point = new Point(wall[0], wall[1]);
            wallsByX.add(point);
            wallsByY.add(point);
            occupied.add(point);
        }

        int ans = m * n - occupied.size();
        Point point, guard, wall;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                point = new Point(i, j);
                if (occupied.contains(point)) continue;

                //guard is in the same row and on the left of point
                guard = guardsByX.floor(point);
                wall = wallsByX.floor(point);
                if (guard != null && guard.x == point.x && (wall == null || wall.x != point.x || wall.y < guard.y)) {
                    ans--;
                    continue;
                }

                //guard is in the same row and ont the right of point
                guard = guardsByX.ceiling(point);
                wall = wallsByX.ceiling(point);
                if (guard != null && guard.x == point.x && (wall == null || wall.x != point.x || wall.y > guard.y)) {
                    ans--;
                    continue;
                }

                //guard is in the same column and on the top of point
                guard = guardsByY.floor(point);
                wall = wallsByY.floor(point);
                if (guard != null && guard.y == point.y && (wall == null || wall.y != point.y || wall.x < guard.x)) {
                    ans--;
                    continue;
                }

                //guard is in the same column and on the bottom of point
                guard = guardsByY.ceiling(point);
                wall = wallsByY.ceiling(point);
                if (guard != null && guard.y == point.y && (wall == null || wall.y != point.y || wall.x > guard.x)) {
                    ans--;
                }
            }
        }
        return ans;
    }


    private record Point(int x, int y) {
    }
}

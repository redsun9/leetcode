package leetcode.leetcode9xx.leetcode963;

import java.util.*;

public class Solution3 implements MinAreaRectFinder {

    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        int ans = Integer.MAX_VALUE;
        boolean foundRect = false;
        HashMap<EdgeClass, PriorityQueue<int[]>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int slopeX = points[j][0] - points[i][0];
                int slopeY = points[j][1] - points[i][1];
                int gcd = gcd(slopeX, slopeY);
                if (gcd == 0) {
                    System.out.println("OMG");
                }
                final int fSlopeX = slopeX / gcd;
                final int fSlopeY = slopeY / gcd;
                int posI = fSlopeX * points[i][0] + fSlopeY * points[i][1];
                int posJ = fSlopeX * points[j][0] + fSlopeY * points[j][1];
                int pos0 = Math.min(posI, posJ);
                int pos1 = Math.max(posI, posJ);
                EdgeClass edgeClass = new EdgeClass(fSlopeX, fSlopeY, pos0, pos1);
                PriorityQueue<int[]> treeSet = map.getOrDefault(edgeClass, new PriorityQueue<>(Comparator.comparingInt((int[] point) -> point[4])));
                treeSet.add(new int[]{
                        points[i][0], points[i][1], points[j][0], points[j][1],
                        (points[i][0] + points[j][0]) * fSlopeY - (points[i][1] + points[j][1]) * fSlopeX
                });
                map.put(edgeClass, treeSet);
            }
        }
        for (Map.Entry<EdgeClass, PriorityQueue<int[]>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                foundRect = true;
                Iterator<int[]> iterator = entry.getValue().iterator();
                int[] prev = iterator.next();
                while (iterator.hasNext()) {
                    int[] next = iterator.next();
                    int s = Math.abs(Math.abs((prev[2] - prev[0]) * (next[1] - prev[1]) - (prev[3] - prev[1]) * (next[0] - prev[0])));
                    ans = Math.min(ans, s);
                    prev = next;
                }
            }
        }
        return foundRect ? ans : 0;
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    private static class EdgeClass {
        int slopeX, slopeY, pos0, pos1;

        public EdgeClass(int slopeX, int slopeY, int pos0, int pos1) {
            this.slopeX = slopeX;
            this.slopeY = slopeY;
            this.pos0 = pos0;
            this.pos1 = pos1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EdgeClass edgeClass = (EdgeClass) o;
            return slopeX == edgeClass.slopeX &&
                    slopeY == edgeClass.slopeY &&
                    pos0 == edgeClass.pos0 &&
                    pos1 == edgeClass.pos1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(slopeX, slopeY, pos0, pos1);
        }
    }
}

package leetcode.leetcode18xx.leetcode1828;

public class Solution {
    //if the circle and rectangle are overlapped
    private static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int p_X = x_center >= x2 ? x2 : Math.max(x_center, x1);
        int p_Y = y_center >= y2 ? y2 : Math.max(y_center, y1);
        return (p_X - x_center) * (p_X - x_center) + (p_Y - y_center) * (p_Y - y_center) <= radius * radius;
    }

    //if the rectangle are all covered by circle
    private static boolean checkCover(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int a = Math.max(Math.abs(x_center - x1), Math.abs(x_center - x2));
        int b = Math.max(Math.abs(y_center - y1), Math.abs(y_center - y2));
        return radius * radius >= a * a + b * b;
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        QuadTree tree = new QuadTree(0, 0, 500, 500);
        for (int[] point : points) tree.addPoint(point[0], point[1]);
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            ans[i] = tree.countPoints(query[0], query[1], query[2]);
        }
        return ans;
    }

    private static class QuadTree {
        final int x1, y1, x2, y2;
        int numberOfPoints;
        QuadTree lt, rt, lb, rb;
        Integer x, y;

        public QuadTree(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        private QuadTree(int x1, int y1, int x2, int y2, int x, int y, int numberOfPoints) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x = x;
            this.y = y;
            this.numberOfPoints = numberOfPoints;
        }

        public void addPoint(int x, int y) {
            this.addPoint(x, y, 1);
        }

        public int countPoints(int x, int y, int r) {
            if (checkCover(x, y, r)) return this.numberOfPoints;
            if (!checkOverlap(x, y, r) || numberOfPoints == 0) return 0;
            if (this.x != null) {
                if ((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) <= r * r) return this.numberOfPoints;
                else return 0;
            } else {
                int ans = 0;
                if (lt != null) ans += lt.countPoints(x, y, r);
                if (rt != null) ans += rt.countPoints(x, y, r);
                if (lb != null) ans += lb.countPoints(x, y, r);
                if (rb != null) ans += rb.countPoints(x, y, r);
                return ans;
            }
        }

        private void addPoint(int x, int y, int numberOfPoints) {
            if (this.x != null && this.x == x && this.y == y) this.numberOfPoints += numberOfPoints;
            else if (this.x == null && numberOfPoints == 0) {
                this.x = x;
                this.y = y;
                this.numberOfPoints = numberOfPoints;
            } else {
                if (this.x != null) {
                    this.addPointToSubtree(this.x, this.y, this.numberOfPoints);
                    this.x = null;
                    this.y = null;
                }
                this.numberOfPoints += numberOfPoints;
                addPointToSubtree(x, y, numberOfPoints);
            }
        }

        private void addPointToSubtree(int x, int y, int numberOfPoints) {
            int midX = x1 + (x2 - x1) / 2;
            int midY = y1 + (y2 - y1) / 2;
            if (midX >= x) {
                if (midY >= y) {
                    if (this.lb == null) this.lb = new QuadTree(x1, y1, midX, midY, x, y, numberOfPoints);
                    else this.lb.addPoint(x, y, numberOfPoints);
                } else {
                    if (this.lt == null) this.lt = new QuadTree(x1, midY + 1, midX, y2, x, y, numberOfPoints);
                    else this.lt.addPoint(x, y, numberOfPoints);
                }
            } else {
                if (midY >= y) {
                    if (this.rb == null) this.rb = new QuadTree(midX + 1, y1, x2, midY, x, y, numberOfPoints);
                    else this.rb.addPoint(x, y, numberOfPoints);
                } else {
                    if (this.rt == null) this.rt = new QuadTree(midX + 1, midY + 1, x2, y2, x, y, numberOfPoints);
                    else this.rt.addPoint(x, y, numberOfPoints);
                }
            }
        }

        private boolean checkCover(int x, int y, int r) {
            return Solution.checkCover(r, x, y, x1, y1, x2, y2);
        }

        private boolean checkOverlap(int x, int y, int r) {
            return Solution.checkOverlap(r, x, y, x1, y1, x2, y2);
        }
    }
}

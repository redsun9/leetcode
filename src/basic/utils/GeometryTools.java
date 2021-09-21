package basic.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class GeometryTools {
    private static final double EPS = 1e-18;

    // doubled signed triangle area
    public static int signedTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }

    public static double signedTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }

    public static int signedTriangleArea(int[] p1, int[] p2, int[] p3) {
        return (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);
    }

    public static double signedTriangleArea(double[] p1, double[] p2, double[] p3) {
        return (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);
    }

    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(signedTriangleArea(x1, y1, x2, y2, x3, y3)) / 2.0;
    }

    public static double triangleArea(int[] p1, int[] p2, int[] p3) {
        return Math.abs(signedTriangleArea(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1])) / 2.0;
    }

    public static boolean clockwise(int x1, int y1, int x2, int y2, int x3, int y3) {
        return signedTriangleArea(x1, y1, x2, y2, x3, y3) < 0;
    }

    public static boolean clockwise(int[] p1, int[] p2, int[] p3) {
        return signedTriangleArea(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]) < 0;
    }

    public static boolean counterClockwise(int x1, int y1, int x2, int y2, int x3, int y3) {
        return signedTriangleArea(x1, y1, x2, y2, x3, y3) > 0;
    }

    public static boolean counterClockwise(int[] p1, int[] p2, int[] p3) {
        return signedTriangleArea(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]) > 0;
    }

    public static double[] lineIntersection(
            double x1, double y1, double x2, double y2,
            double x3, double y3, double x4, double y4
    ) {
        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (Math.abs(d) < EPS) return null;

        double d1 = x1 * y2 - y1 * x2, d2 = x3 * y4 - y3 * x4;
        double x = d1 * (x3 - x4) - d2 * (x1 - x2);
        double y = d1 * (y3 - y4) - d2 * (y1 - y2);
        return new double[]{x / d, y / d};
    }

    public static double[] lineIntersection(
            double[] p1, double[] p2, double[] p3, double[] p4
    ) {
        return lineIntersection(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1], p4[0], p4[1]);
    }

    public static double[] lineIntersection(
            double a1, double b1, double c1,
            double a2, double b2, double c2
    ) {
        double d = a1 * b2 - b1 * a2;
        if (Math.abs(d) < EPS) return null;

        double x = (c1 * b2 - c2 * b1) / d;
        double y = (a1 * c2 - a2 * c1) / d;
        return new double[]{x, y};
    }

    public static boolean segmentIntersects(double a, double b, double c, double d) {
        double a1 = Math.min(a, b), b1 = Math.max(a, b);
        double c1 = Math.min(c, d), d1 = Math.max(c, d);
        return a1 <= d1 && c1 <= b1;
    }

    public static boolean segmentIntersects(
            double x1, double y1, double x2, double y2,
            double x3, double y3, double x4, double y4
    ) {
        return segmentIntersects(x1, x2, x3, x4) && segmentIntersects(y1, y2, y3, y4) &&
                signedTriangleArea(x1, y1, x2, y2, x3, y3) * signedTriangleArea(x1, y1, x2, y2, x4, y4) <= 0 &&
                signedTriangleArea(x3, y3, x4, y4, x1, y1) * signedTriangleArea(x3, y3, x4, y4, x2, y2) <= 0;
    }

    public static double polygonSquare(double[][] points) {
        double ans = 0;
        double[] prev = points[points.length - 1];
        for (double[] curr : points) {
            ans += (prev[0] - curr[0]) * (prev[1] + curr[1]);
            prev = curr;
        }
        return Math.abs(ans) / 2;
    }

    public static double[] massCenterOfPoints(double[][] points) {
        double sumX = 0, sumY = 0, sum = 0;
        for (double[] point : points) {
            sumX += point[0] * point[2];
            sumY += point[1] * point[2];
            sum += point[2];
        }
        return new double[]{sumX / sum, sumY / sum};
    }

    public static double[] massCenterOfEdges(double[][] points) {
        double sumX = 0, sumY = 0, sum = 0;
        double[] prev = points[points.length - 1];
        for (double[] curr : points) {
            double hypot = Math.hypot(curr[0] - prev[0], curr[1] - prev[1]);
            sumX += (curr[0] + prev[0]) * hypot;
            sumY += (curr[1] + prev[1]) * hypot;
            sum += hypot;
            prev = curr;
        }
        return new double[]{sumX / sum / 2.0, sumY / sum / 2.0};
    }

    public static double[] massCenterOfPolygon(double[][] points) {
        double sumX = 0, sumY = 0, sum = 0;
        double[] zero = {0, 0};
        double[] prev = points[points.length - 1];
        for (double[] curr : points) {
            double s = signedTriangleArea(zero, prev, curr);
            sumX += (curr[0] + prev[0]) * s;
            sumY += (curr[1] + prev[1]) * s;
            sum += s;
            prev = curr;
        }
        return new double[]{sumX / sum / 3.0, sumY / sum / 3.0};
    }

    private static double[][] lineCircleIntersection(
            double a, double b, double c, double r
    ) {
        double x0 = -a * c / (a * a + b * b), y0 = -b * c / (a * a + b * b);
        double v = r * r * (a * a + b * b);
        if (c * c > v + EPS)
            return new double[0][];
        else if (Math.abs(c * c - v) < EPS) {
            return new double[][]{{x0, y0}};
        } else {
            double d = r * r - c * c / (a * a + b * b);
            double mult = Math.sqrt(d / (a * a + b * b));
            return new double[][]{
                    {x0 + b * mult, y0 - a * mult},
                    {x0 - b * mult, y0 + a * mult}
            };
        }
    }

    public static double[][] lineCircleIntersection(
            double a, double b, double c,
            double z0, double z1, double r
    ) {
        c += z0 * a + z1 * b;
        double[][] points = lineCircleIntersection(a, b, c, r);
        for (double[] p : points) {
            p[0] += z0;
            p[1] += z1;
        }
        return points;
    }

    public static double[][] twoCirclesIntersection(
            double x1, double y1, double r1,
            double x2, double y2, double r2
    ) {
        x2 -= x1;
        y2 -= y1;
        double a = -2.0 * x2;
        double b = -2.0 * y2;
        double c = x2 * x2 + y2 * y2 + r1 * r1 - r2 * r2;

        double[][] points = lineCircleIntersection(a, b, c, r1);
        for (double[] p : points) {
            p[0] += x1;
            p[1] += y1;
        }
        return points;
    }

    private static void tangentLinesForTwoCircles(
            double x, double y, double r1, double r2, List<double[]> ans
    ) {
        double r = r2 - r1;
        double z = x * x + y * y;
        double d = z - r * r;
        if (d < -EPS) return;
        d = Math.sqrt(Math.abs(d));
        double[] line = {(x * r + y * d) / z, (y * r - x * d) / z, r1};
        ans.add(line);
    }

    public static List<double[]> tangentLinesForTwoCircles(
            double x1, double y1, double r1,
            double x2, double y2, double r2
    ) {
        List<double[]> ans = new ArrayList<>();
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                tangentLinesForTwoCircles(x2 - x1, y2 - y1, r1 * i, r2 * j, ans);
            }
        }

        for (double[] line : ans) {
            if (line[2] < 0) {
                line[0] = -line[0];
                line[1] = -line[1];
                line[2] = -line[2];
            } else if (line[2] == 0 && line[0] < 0) {
                line[0] = -line[0];
                line[1] = -line[1];
            } else if (line[2] == 0 && line[0] == 0 && line[1] < 0) {
                line[1] = -line[1];
            }
        }

        if (ans.size() >= 2) {
            ans.sort(Comparator.comparingDouble((double[] p) -> p[0])
                    .thenComparingDouble(p -> p[1])
                    .thenComparingDouble(p -> p[2])
            );
            double[] prev = ans.get(0), curr;
            ListIterator<double[]> iterator = ans.listIterator(1);
            while (iterator.hasNext()) {
                curr = iterator.next();
                boolean same = true;
                for (int i = 0; same && i < 3; i++) same = Math.abs(curr[i] - prev[i]) < EPS;
                if (same) iterator.remove();
                else prev = curr;
            }
        }
        for (double[] line : ans) line[2] -= line[0] * x1 + line[1] * y1;
        return ans;
    }
}

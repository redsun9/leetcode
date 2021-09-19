package google.kickstart2021.roundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.hypot;

public class StarTrappers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = parseInt(scanner.nextLine());
        String[] parts;
        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            int n = parseInt(scanner.nextLine());
            int[][] ws = new int[n][2];
            for (int i = 0; i < n; i++) {
                parts = scanner.nextLine().split(" ");
                ws[i][0] = Integer.parseInt(parts[0]);
                ws[i][1] = Integer.parseInt(parts[1]);
            }
            parts = scanner.nextLine().split(" ");
            int[] bs = {parseInt(parts[0]), parseInt(parts[1])};
            double ans = solve(ws, bs);
            if (ans != Double.POSITIVE_INFINITY) {
                System.out.println("Case #" + testIndex + ": " + ans);
            } else {
                System.out.println("Case #" + testIndex + ": IMPOSSIBLE");
            }

        }
    }

    private static double solve(int[][] ws, int[] bs) {
        int n = ws.length;
        double ans = Double.POSITIVE_INFINITY;
        HashMap<Angle, Distance> angles = new HashMap<>();

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                if (onSameLine(ws[i], ws[j], bs)) continue;
                for (int k = 0; k < j; k++) {
                    if (onSameLine(ws[i], ws[k], bs) || onSameLine(ws[j], ws[k], bs)) continue;
                    if (insideTriangle(ws[i], ws[j], ws[k], bs)) ans = Math.min(ans, perimeter(ws[i], ws[j], ws[k]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ws[i][0] == bs[0] && ws[i][1] == bs[1]) continue;
            Angle key = new Angle(bs[0] - ws[i][0], bs[1] - ws[i][1]);
            long hypot2 = (long) (bs[0] - ws[i][0]) * (bs[0] - ws[i][0]) + (long) (bs[1] - ws[i][1]) * (bs[1] - ws[i][1]);
            Distance prevValue = angles.get(key);
            if (prevValue == null || prevValue.dist > hypot2) {
                Distance newVal = new Distance(i, hypot2);
                angles.put(key, newVal);
            }
        }

        List<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Angle, Distance> entry : angles.entrySet()) {
            if (entry.getKey().x < 0) continue;
            if (entry.getKey().x == 0 && entry.getKey().y < 0) continue;
            Distance opposite = angles.get(new Angle(-entry.getKey().x, -entry.getKey().y));
            if (opposite == null) continue;
            pairs.add(new int[]{entry.getValue().index, opposite.index});
        }

        int m = pairs.size();
        for (int i = 1; i < m; i++) {
            int[] p1 = pairs.get(i);
            for (int j = 0; j < i; j++) {
                int[] p2 = pairs.get(j);
                ans = Math.min(ans, perimeter(ws[p1[0]], ws[p2[0]], ws[p1[1]], ws[p2[1]]));
            }
        }

        return ans;
    }


    private static double perimeter(int[] a, int[] b, int[] c) {
        return hypot(a[0] - b[0], a[1] - b[1]) + hypot(a[0] - c[0], a[1] - c[1]) + hypot(b[0] - c[0], b[1] - c[1]);
    }

    private static double perimeter(int[] a, int[] b, int[] c, int[] d) {
        return hypot(a[0] - b[0], a[1] - b[1]) + hypot(b[0] - c[0], b[1] - c[1])
                + hypot(c[0] - d[0], c[1] - d[1]) + hypot(d[0] - a[0], d[1] - a[1]);
    }

    private static boolean onSameLine(int[] a, int[] b, int[] c) {
        return (long) (b[0] - a[0]) * (c[1] - a[1]) == (long) (b[1] - a[1]) * (c[0] - a[0]);
    }

    private static boolean insideTriangle(int[] a, int[] b, int[] c, int[] p) {
        return abs(square(a, b, p)) + abs(square(a, c, p)) + abs(square(b, c, p)) == abs(square(a, b, c));
    }

    private static long square(int[] a, int[] b, int[] c) {
        return (long) (b[0] - a[0]) * (c[1] - a[1]) - (long) (b[1] - a[1]) * (c[0] - a[0]);
    }

    private static class Angle {
        final int x, y;

        private Angle(int x, int y) {
            int g = Math.abs(gcd(x, y));
            this.x = x / g;
            this.y = y / g;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Angle angle = (Angle) o;
            return x == angle.x && y == angle.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class Distance {
        final int index;
        final long dist;

        public Distance(int index, long dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}

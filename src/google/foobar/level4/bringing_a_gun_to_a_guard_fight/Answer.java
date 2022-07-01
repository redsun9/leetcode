package google.foobar.level4.bringing_a_gun_to_a_guard_fight;

import java.util.HashMap;
import java.util.Map;

public class Answer {
    public static int answer(int[] dimensions, int[] myPosition, int[] guardPosition, int distance) {
        Map<Angle, Integer> map = new HashMap<>();
        int w = dimensions[0], h = dimensions[1];

        int x1 = myPosition[0], y1 = myPosition[1];
        int[] x1Mirrored = {x1, w - x1};
        int[] y1Mirrored = {y1, h - y1};

        int[] x2Mirrored = {guardPosition[0], w - guardPosition[0]};
        int[] y2Mirrored = {guardPosition[1], h - guardPosition[1]};

        int squaredMaxDistance = distance * distance;
        int distW = (distance + w - 1) / w, distH = (distance + h - 1) / h;

        //put the closest guards with their squared distance for each angle
        for (int i = -distW; i <= distW; i++) {
            int x2Virtual = w * i + x2Mirrored[i & 1] - x1;
            for (int j = -distH; j <= distH; j++) {
                int y2Virtual = h * j + y2Mirrored[j & 1] - y1;
                int dist2 = x2Virtual * x2Virtual + y2Virtual * y2Virtual;
                if (dist2 > squaredMaxDistance) continue;
                map.compute(getAngle(x2Virtual, y2Virtual), (k, v) -> v == null ? dist2 : Math.min(dist2, v));
            }
        }

        //remove guards if there are myself closer for each angle
        for (int i = -distW; i <= distW; i++) {
            int x2Virtual = w * i + x1Mirrored[i & 1] - x1;
            for (int j = -distH; j <= distH; j++) {
                if (i == 0 && j == 0) continue;
                int y2Virtual = h * j + y1Mirrored[j & 1] - y1;
                int dist2 = x2Virtual * x2Virtual + y2Virtual * y2Virtual;
                if (dist2 > squaredMaxDistance) continue;
                map.compute(getAngle(x2Virtual, y2Virtual), (k, v) -> v == null || v > dist2 ? null : v);
            }
        }

        //remove guards if there are corner closer for each angle
        for (int i = -distW; i <= distW; i++) {
            int x2Virtual = w * i - x1;
            for (int j = -distH; j <= distH; j++) {
                int y2Virtual = h * j - y1;
                int dist2 = x2Virtual * x2Virtual + y2Virtual * y2Virtual;
                if (dist2 > squaredMaxDistance) continue;
                map.compute(getAngle(x2Virtual, y2Virtual), (k, v) -> v == null || v > dist2 ? null : v);
            }
        }
        return map.size();
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static Angle getAngle(int a, int b) {
        int gcd = gcd(Math.abs(a), Math.abs(b));
        return new Angle(a / gcd, b / gcd);
    }

    private record Angle(int x, int y) {
    }
}

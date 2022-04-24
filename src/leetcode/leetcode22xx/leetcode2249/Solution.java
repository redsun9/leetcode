package leetcode.leetcode22xx.leetcode2249;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    private static final int MAX_VAL = 2 * 100;

    public int countLatticePoints(int[][] circles) {
        List<int[]>[] list = new List[MAX_VAL + 1];
        for (int i = 0; i < list.length; i++) list[i] = new ArrayList<>();

        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            for (int i = x - r; i <= x + r; i++) {
                int dy = (int) Math.round(Math.sqrt(r * r - (i - x) * (i - x)));
                if (dy * dy + (i - x) * (i - x) > r * r) dy--;
                list[i].add(new int[]{y - dy, y + dy});
            }
        }

        int ans = 0;
        for (List<int[]> segments : list) {
            int size = segments.size();
            if (size == 0) continue;
            segments.sort(Comparator.comparingInt(a -> a[0]));
            int left = segments.get(0)[0], right = segments.get(0)[1];
            for (int[] segment : segments) {
                if (segment[0] > right) {
                    ans += right - left + 1;
                    left = segment[0];
                    right = segment[1];
                } else if (segment[1] > right) {
                    right = segment[1];
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }
}

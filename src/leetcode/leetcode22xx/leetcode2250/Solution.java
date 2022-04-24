package leetcode.leetcode22xx.leetcode2250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    private static final int MAX_HEIGHT = 100;

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] rectanglesWithHeight = new List[MAX_HEIGHT + 1];
        for (int[] rectangle : rectangles) {
            int width = rectangle[0], height = rectangle[1];
            if (rectanglesWithHeight[height] == null) rectanglesWithHeight[height] = new ArrayList<>();
            rectanglesWithHeight[height].add(width);
        }
        for (List<Integer> list : rectanglesWithHeight) {
            if (list != null) Collections.sort(list);
        }


        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int count = 0;
            for (int height = y; height <= MAX_HEIGHT; height++) {
                List<Integer> list = rectanglesWithHeight[height];
                if (list == null) continue;
                int left = 0, right = list.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < x) left = mid + 1;
                    else right = mid;
                }
                count += list.size() - left;
            }
            result[i] = count;
        }
        return result;
    }
}

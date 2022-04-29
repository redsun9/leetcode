package codeforces.contest1672.problemE;

import java.util.Map;
import java.util.TreeMap;

public class Solver {
    private static final int MAX_LEN = 2000;
    private final Grader grader;

    public Solver(Grader grader) {
        this.grader = grader;
    }

    public void solve() {
        int n = grader.getN();
        int lo = 2 * n - 1, hi = n * (MAX_LEN + 1) - 1;

        // possible length of the longest string
        int currentMaxLengthMin = 1;
        Map<Integer, Integer> answers = new TreeMap<>();
        int minArea = hi;
        while (lo < hi) {
            int w = (lo + hi) / 2;
            int h = grader.test(w);
            if (h != 1) lo = w + 1;
            else hi = w;
            if (h != 0) {
                answers.put(w, h);
                minArea = Math.min(minArea, w * h);
            } else currentMaxLengthMin = Math.max(currentMaxLengthMin, w + 1);
        }
        int[] heights = new int[n];
        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            int w = entry.getKey();
            int h = entry.getValue();
            if (heights[h - 1] == 0) heights[h - 1] = w;
            else heights[h - 1] = Math.min(heights[h - 1], w);
        }

        int s = lo;
        heights[0] = s;

        for (int h = 2; h <= n; h++) {
            if (heights[h - 1] == 0) heights[h - 1] = heights[h - 2];
            else heights[h - 1] = Math.min(heights[h - 1], heights[h - 2]);
            int length = s / h;
            length = Math.min(length, heights[h - 2] - 1);
            length = Math.max(length, currentMaxLengthMin);
            if (heights[h - 1] != 0 && heights[h - 1] <= length) continue;
            if (length * h >= minArea) continue;
            int actualH;
            if (answers.containsKey(length)) actualH = answers.get(length);
            else actualH = grader.test(length);
            if (actualH != 0) {
                minArea = Math.min(minArea, length * actualH);
                answers.put(length, actualH);
                if (actualH == h) {
                    heights[h - 1] = length;
                } else {
                    if (heights[actualH - 1] == 0 || heights[actualH - 1] > length) heights[actualH - 1] = length;
                }
            } else currentMaxLengthMin = Math.max(currentMaxLengthMin, length + 1);
        }
        grader.checkAns(minArea);
    }
}

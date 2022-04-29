package codeforces.contest1672.problemE;

public class GraderImpl implements Grader {
    private final int n, maxLength;
    private final int totalLength;
    private final int minArea;
    private final int[] widths;
    private boolean solved = false;
    private int numberOfTries = 0;

    public GraderImpl(int[] words) {
        this.n = words.length;
        int max = 0, sum = n - 1;
        for (int word : words) {
            max = Math.max(max, word);
            sum += word;
        }
        this.maxLength = max;
        this.totalLength = sum;

        int minArea = totalLength;
        widths = new int[n];
        widths[0] = totalLength;
        for (int i = 1; i < n; i++) widths[i] = getMinWidthForHeight(words, i + 1, widths[i - 1]);
        for (int i = 0; i < n; i++) minArea = Math.min(minArea, widths[i] * (i + 1));
        this.minArea = minArea;
    }

    @Override
    public int test(int w) {
        numberOfTries++;
        if (w < maxLength) return 0;
        if (w >= totalLength) return 1;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (widths[mid] > w) lo = mid + 1;
            else hi = mid;
        }
        return lo + 1;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public void checkAns(int minArea) {
        solved = minArea == this.minArea;
    }

    public boolean iSolved() {
        return solved;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    private int getMinWidthForHeight(int[] words, int height, int hi) {
        int lo = maxLength;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(words, mid, height)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] words, int width, int height) {
        int sum = -1;
        int ans = 1;
        for (int word : words) {
            sum += word + 1;
            if (sum > width) {
                if (++ans > height) return false;
                sum = word;
            }
        }
        return true;
    }
}

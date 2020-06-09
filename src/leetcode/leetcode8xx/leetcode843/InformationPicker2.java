package leetcode.leetcode8xx.leetcode843;

public class InformationPicker2 implements Picker {
    private static final double EPS = 1e-10;

    @Override
    public int pickNext(int[][] a, boolean[] removed, int m, int n, int candidates) {
        if (candidates == 1) {
            for (int i = 0; i < m; i++) {
                if (!removed[i]) return i;
            }
        }
        double maxInfo = -1;
        int maxIndex = -1;
        for (int i = 0; i < m; i++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < m; j++) {
                if (!removed[j]) count[a[i][j]]++;
            }
            double tmp = 0;
            for (int c : count) {
                if (c == 0) continue;
                tmp = tmp - c * Math.log(c / (double) candidates);
            }
            if ((maxInfo < tmp) || ((maxInfo < tmp + EPS) && !removed[i])) {
                maxInfo = tmp;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

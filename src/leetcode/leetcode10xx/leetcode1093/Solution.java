package leetcode.leetcode10xx.leetcode1093;

public class Solution {
    private static final int N = 255;

    public double[] sampleStats(int[] count) {
        int min = 0;
        while (count[min] == 0) min++;

        int max = N;
        while (count[max] == 0) max--;

        long sum = 0, total = 0;
        for (int i = 0; i <= N; i++) {
            total += count[i];
            sum += (long) i * count[i];
        }

        int mode = 0, maxCount = 0;
        for (int i = 0; i < 255; i++) {
            if (count[i] > maxCount) {
                mode = i;
                maxCount = count[i];
            }
        }

        double median;
        if ((total & 1) == 1) {
            int l = 0;
            long threshold = total >> 1;
            while (threshold >= 0) threshold -= count[l++];
            median = l - 1;
        } else {
            int l = 0;
            long threshold = total >> 1;
            while (threshold > 0) threshold -= count[l++];

            int r = 255;
            threshold = total >> 1;
            while (threshold > 0) threshold -= count[r--];
            median = (l + r) / 2.0;
        }

        return new double[]{min, max, (double) sum / total, median, mode};
    }
}

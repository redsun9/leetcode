package distribution;

import prng.XorShift1024;

import java.util.Arrays;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class UniformCategorialDistribution {

    // distribution.distribution of max of uniform categorial distribution.distribution
    public static double[] univariateMax(int m, int n, int tests) {
        long[] seed = new long[16];
        seed[0] = 1;
        XorShift1024 random = new XorShift1024(seed);

        int[] buckets = new int[m];
        int[] stats = new int[n + 1];
        for (int t = 0; t < tests; t++) {
            Arrays.fill(buckets, 0);
            for (int i = 0; i < n; i++) {
                int c = (int) (random.nextLong() % m);
                if (c < 0) c += m;
                buckets[c]++;
            }
            int max = 0;
            for (int bucket : buckets) max = Math.max(max, bucket);
            stats[max]++;
        }
        double[] ans = new double[n + 1];
        double multiplier = 1.0 / tests;
        for (int i = 0; i <= n; i++) ans[i] = stats[i] * multiplier;
        return ans;
    }

    // distribution.distribution of k-th max of uniform categorial distribution.distribution
    public static double[] univariateKthMax(int m, int n, int k, int tests) {
        long[] seed = new long[16];
        seed[0] = 1;
        XorShift1024 random = new XorShift1024(seed);

        int[] buckets = new int[m];
        int[] stats = new int[n + 1];
        for (int t = 0; t < tests; t++) {
            Arrays.fill(buckets, 0);
            for (int i = 0; i < n; i++) {
                int c = (int) (random.nextLong() % m);
                if (c < 0) c += m;
                buckets[c]++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
            for (int bucket : buckets) {
                pq.offer(bucket);
                if (pq.size() > k) pq.poll();
            }
            stats[pq.peek()]++;
        }
        double[] ans = new double[n + 1];
        double multiplier = 1.0 / tests;
        for (int i = 0; i <= n; i++) ans[i] = stats[i] * multiplier;
        return ans;
    }

    // distribution.distribution of sum k max of uniform categorial distribution.distribution
    public static double[] univariateMaxK(int m, int n, int k, int tests) {
        long[] seed = new long[16];
        seed[0] = 1;
        XorShift1024 random = new XorShift1024(seed);

        int[] buckets = new int[m];
        int[] stats = new int[n + 1];
        for (int t = 0; t < tests; t++) {
            Arrays.fill(buckets, 0);
            for (int i = 0; i < n; i++) {
                int c = (int) (random.nextLong() % m);
                if (c < 0) c += m;
                buckets[c]++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
            for (int bucket : buckets) {
                pq.offer(bucket);
                if (pq.size() > k) pq.poll();
            }
            int max = 0;
            while (!pq.isEmpty()) max += pq.poll();
            stats[max]++;
        }
        double[] ans = new double[n + 1];
        double multiplier = 1.0 / tests;
        for (int i = 0; i <= n; i++) ans[i] = stats[i] * multiplier;
        return ans;
    }

    //distribution.distribution of max len of the same value in ordered uniform distribution.distribution
    public static double[] univariateSameMaxLen(int m, int n, int tests) {
        long[] seed = new long[16];
        seed[0] = 1;
        XorShift1024 random = new XorShift1024(seed);

        int[] stats = new int[n + 1];
        for (int t = 0; t < tests; t++) {
            int max = 0;
            for (int i = 0, prev = -1, curr = 0; i < n; i++) {
                int c = (int) (random.nextLong() % m);
                if (c < 0) c += m;
                if (c != prev) curr = 0;
                curr++;
                max = Math.max(max, curr);
                prev = c;
            }
            stats[max]++;
        }
        double[] ans = new double[n + 1];
        double multiplier = 1.0 / tests;
        for (int i = 0; i <= n; i++) ans[i] = stats[i] * multiplier;
        return ans;
    }

    /*
            expected max - 3.930323
            2 1.000000
            3 0.999735
            4 0.728517
            5 0.174802
            6 0.024303
            7 0.002646
            8 0.000273
            9 0.000026

            expected k-th max - 3.086700
            2 1.000000
            3 0.979574
            4 0.106553
            5 0.000567

            expected sum k max - 10.371000
            6 1.000000
            7 0.999735
            8 0.997309
            9 0.986722
            10 0.722794
            11 0.404898
            12 0.183316
            13 0.058191
            14 0.014418
            15 0.002968
            16 0.000510
            17 0.000090
            18 0.000014
            19 0.000002

            expected same max len - 1.570077
            1 1.000000
            2 0.563254
            3 0.006764
            4 0.000047
    */
    public static void main(String[] args) {
        int m = 120, n = 100, k = 3;
        int numberOfTests = 1_000_000;

        double[] stats1 = univariateMax(m, n, numberOfTests);
        double expectedMax = 0;
        for (int i = 1; i <= n; i++) {
            expectedMax += i * stats1[i];
            stats1[i] += stats1[i - 1];
        }
        System.out.format("expected max - %.6f\n", expectedMax);
        for (int i = 2; i < 10; i++) System.out.format("%d %.6f\n", i, 1.0 - stats1[i - 1]);

        System.out.println();
        double[] stats2 = univariateKthMax(m, n, k, numberOfTests);
        double expectedKthMax = 0;
        for (int i = 1; i <= n; i++) {
            expectedKthMax += i * stats2[i];
            stats2[i] += stats2[i - 1];
        }
        System.out.format("expected k-th max - %.6f\n", expectedKthMax);
        for (int i = 2; i <= 5; i++) System.out.format("%d %.6f\n", i, 1.0 - stats2[i - 1]);

        System.out.println();
        double[] stats3 = univariateMaxK(m, n, k, numberOfTests);
        double expectedMaxK = 0;
        for (int i = 1; i <= n; i++) {
            expectedMaxK += i * stats3[i];
            stats3[i] += stats3[i - 1];
        }
        System.out.format("expected sum k max - %.6f\n", expectedMaxK);
        for (int i = 6; i < 20; i++) System.out.format("%d %.6f\n", i, 1.0 - stats3[i - 1]);

        System.out.println();
        double[] stats4 = univariateSameMaxLen(m, n, numberOfTests);
        double expectedSameMaxLen = 0;
        for (int i = 1; i <= n; i++) {
            expectedSameMaxLen += i * stats4[i];
            stats4[i] += stats4[i - 1];
        }
        System.out.format("expected same max len - %.6f\n", expectedSameMaxLen);
        for (int i = 1; i < 5; i++) System.out.format("%d %.6f\n", i, 1.0 - stats4[i - 1]);
    }
}

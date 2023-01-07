package help_requests.spearman;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("DuplicatedCode")
public class JavaSolution {
    public static double spearmanUnique(Double[] xs, Double[] ys) {
        if (xs == null || ys == null || xs.length != ys.length || xs.length < 2) throw new IllegalArgumentException();

        int n = xs.length;
        int[] xRanks = ranksUnique(xs), yRanks = ranksUnique(ys);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            long d = xRanks[i] - yRanks[i];
            sum += d * d;
        }
        return 1.0 - 6.0 * sum / n / ((long) n * n - 1);
    }

    public static <X extends Comparable<? super X>, Y extends Comparable<? super Y>> double spearmanNonUnique(X[] xs, Y[] ys) {
        if (xs == null || ys == null || xs.length != ys.length || xs.length < 2) throw new IllegalArgumentException();
        int n = xs.length;
        double[] xRanks = ranksNonUnique(xs), yRanks = ranksNonUnique(ys);
        double sum = 0;
        for (int i = 0; i < n; i++) sum += (xRanks[i] - yRanks[i]) * (xRanks[i] - yRanks[i]);
        return 1.0 - 6.0 * sum / n / ((long) n * n - 1);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<? super T>> int[] ranksUnique(T[] xs) {
        int n = xs.length;
        Pair<T>[] xSorted = new Pair[n];
        for (int i = 0; i < n; i++) xSorted[i] = new Pair<>(i, xs[i]);
        Arrays.sort(xSorted, Comparator.comparing(Pair::val));
        int[] xRanks = new int[n];
        for (int i = 0; i < n; i++) xRanks[xSorted[i].idx] = i;
        return xRanks;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<? super T>> double[] ranksNonUnique(T[] xs) {
        int n = xs.length;
        Pair<T>[] sortedValues = new Pair[n];
        for (int i = 0; i < n; i++) sortedValues[i] = new Pair<>(i, xs[i]);
        Arrays.sort(sortedValues, Comparator.comparing(Pair::val));

        double[] xRanks = new double[n];
        int left = 0;
        while (left < n) {
            T value = sortedValues[left].val;
            int right = left + 1;
            while (right < n && value.compareTo(sortedValues[right].val) == 0) right++;
            double averageRank = right == left + 1 ? left : (right - 1.0 + left) / 2.0;
            for (int i = left; i < right; i++) xRanks[sortedValues[i].idx] = averageRank;
            left = right;
        }
        return xRanks;
    }

    private record Pair<T>(int idx, T val) {
    }
}

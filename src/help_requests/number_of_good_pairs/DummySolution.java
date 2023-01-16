package help_requests.number_of_good_pairs;

public class DummySolution {
    public static long numberOfGoodPairs(int[] x, int[] y) {
        int n = x.length;
        long ans = 0;
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) if (x[i] < x[j] == y[i] < y[j]) ans++;
        return ans;
    }
}

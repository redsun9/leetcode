package suggestions.total_imbalance;

import java.util.Arrays;

// O(N^3 logN) - time complexity, O(N) - space complexity
public class Solution2 {
    public long totalImbalance(int[] rank) {
        int n = rank.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                int[] copy = Arrays.copyOfRange(rank, i, j);
                Arrays.sort(copy);
                int m = j - i;
                for (int k = 1; k < m; k++) if (copy[k] - copy[k - 1] > 1) ans++;
            }
        }
        return ans;
    }
}

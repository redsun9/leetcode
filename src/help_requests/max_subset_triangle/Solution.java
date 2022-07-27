package help_requests.max_subset_triangle;

import java.util.Arrays;

public class Solution {
    public static int maxSubset(int[] edges) {
        int n = edges.length;
        if (n <= 2) return 0;
        Arrays.sort(edges);

        int ans = 0, r = n - 1, l = r - 1, s = edges[l] + edges[r];
        while (true) {
            if (edges[l] + edges[l + 1] > edges[r]) {
                if (r - l >= 2 && s > ans) ans = s;
                if (l == 0) return ans;
                s += edges[--l];
            } else {
                s -= edges[r--];
            }
        }
    }
}

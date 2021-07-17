package leetcode.leetcode14xx.leetcode1409;

public class Solution {

    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ans = new int[queries.length];
        int[] indexes = new int[m + 1];
        Fenwick fenwick = new Fenwick(m + n + 1);
        for (int i = 1; i <= m; i++) {
            indexes[i] = n + i;
            fenwick.insert(n + i, 1);
        }
        for (int i = 0; i < n; i++) {
            int index = indexes[queries[i]];
            indexes[queries[i]] = n - i;
            ans[i] = fenwick.prefix(index);
            fenwick.insert(index, -1);
            fenwick.insert(indexes[queries[i]], 1);
        }
        return ans;
    }

    private static class Fenwick {
        final int[] arr;
        final int n;

        Fenwick(int n) {
            this.arr = new int[n];
            this.n = n;
        }

        void insert(int i, int val) {
            for (; i < n; i += i & (-i)) arr[i] += val;
        }

        int prefix(int i) {
            int ans = 0;
            i--;
            for (; i > 0; i -= i & (-i)) ans += arr[i];
            return ans;
        }

    }
}

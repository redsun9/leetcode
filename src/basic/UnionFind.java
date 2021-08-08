package basic;

@SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
public class UnionFind {
    private final int[] p, rank;

    public UnionFind(int n) {
        rank = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
    }

    int find(int x) {
        if (x == p[x]) return x;
        else {
            p[x] = find(p[x]);
            return p[x];
        }
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) p[x] = y;
        else {
            p[y] = x;
            if (rank[x] == rank[y]) ++rank[x];
        }
    }
}

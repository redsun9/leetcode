package leetcode.leetcode20xx.leetcode2092;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[2]));

        int l = 0, m = meetings.length, r, time, expected;
        while (l < m) {
            time = meetings[l][2];
            r = l;
            while (r < m && meetings[r][2] == time) {
                uf.union(meetings[r][0], meetings[r][1]);
                r++;
            }

            expected = uf.find(0);
            while (l < r) {
                if (uf.find(meetings[l][0]) != expected) {
                    uf.reset(meetings[l][0]);
                    uf.reset(meetings[l][1]);
                }
                l++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        expected = uf.find(0);
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == expected) ans.add(i);
        }
        return ans;
    }

    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
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

        void reset(int x) {
            p[x] = x;
            rank[x] = 1;
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
}

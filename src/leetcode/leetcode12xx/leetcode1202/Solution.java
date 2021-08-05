package leetcode.leetcode12xx.leetcode1202;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) uf.union(pair.get(0), pair.get(1));
        HashMap<Integer, Group> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int groupId = uf.find(i);
            Group group = map.get(groupId);
            if (group == null) {
                group = new Group();
                map.put(groupId, group);
            }
            group.count[s.charAt(i) - 'a']++;
        }
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            Group group = map.get(uf.p[i]);
            while (group.count[group.index]-- == 0) group.index++;
            ans[i] = (char) ('a' + group.index);
        }
        return new String(ans);
    }

    private static class Group {
        int[] count = new int[26];
        int index = 0;
    }

    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
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
            if (rank[x] < rank[y])
                p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y])
                    ++rank[x];
            }
        }
    }
}

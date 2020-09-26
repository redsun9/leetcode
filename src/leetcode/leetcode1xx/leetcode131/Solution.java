package leetcode.leetcode1xx.leetcode131;

import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<List<String>> ans = new LinkedList<>();
        List<Edge>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new LinkedList<>();
            //i - is middle
            int l = i, r = i;
            while (l >= 0 && r < n && chars[l] == chars[r]) edges[l].add(new Edge(l--, ++r));
            l = i - 1;
            r = i;
            while (l >= 0 && r < n && chars[l] == chars[r]) edges[l].add(new Edge(l--, ++r));
        }
        dfs(chars, 0, n, new LinkedList<>(), ans, edges, new HashMap<>());
        return ans;
    }

    private static void dfs(
            char[] chars, int pos, int n,
            LinkedList<String> tmp, List<List<String>> ans,
            List<Edge>[] edges, Map<Edge, String> map
    ) {
        if (pos == n) ans.add(List.copyOf(tmp));
        else {
            for (Edge edge : edges[pos]) {
                String substr = map.computeIfAbsent(edge, e -> new String(chars, e.l, e.r - e.l));
                tmp.addLast(substr);
                dfs(chars, edge.r, n, tmp, ans, edges, map);
                tmp.removeLast();
            }
        }
    }

    private static class Edge {
        private final int l, r;

        public Edge(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return l == edge.l &&
                    r == edge.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r);
        }
    }
}

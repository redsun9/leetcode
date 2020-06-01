package basic;

import java.util.*;

public class UndirectedGraph {
    static int count = 0, time = 0;

    private List<Integer>[] adj;

    public UndirectedGraph(int n) {
        adj = new List[n];
    }

    public void addEdge(int u, int v) {
        if (adj[u] == null) adj[u] = new LinkedList<>();
        if (adj[v] == null) adj[v] = new LinkedList<>();
        adj[u].add(v);
        adj[v].add(u);
    }

    public Collection<Collection<Integer>> bcc() {
        int n = adj.length;
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];

        LinkedList<Edge> st = new LinkedList<>();
        List<Collection<Integer>> ansComponents = new LinkedList<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) bccUtil(i, disc, low, st, parent, ansComponents);
            if (!st.isEmpty()) {
                Set<Integer> set = new HashSet<>();
                while (!st.isEmpty()) {
                    Edge edge = st.pollLast();
                    set.add(edge.u);
                    set.add(edge.v);
                }
                ansComponents.add(set);
                count++;
            }
        }
        return ansComponents;
    }

    private void bccUtil(int u, int[] disc, int[] low, LinkedList<Edge> st, int[] parent, List<Collection<Integer>> ans) {
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : adj[u]) {
            // If v is not visited yet, then recur for it
            if (disc[v] == -1) {
                children++;
                parent[v] = u;

                // store the edge in stack
                st.add(new Edge(u, v));
                bccUtil(v, disc, low, st, parent, ans);

                // Check if the subtree rooted with 'v' has a
                // connection to one of the ancestors of 'u'
                // Case 1 -- per Strongly Connected Components Article
                low[u] = Math.min(low[u], low[v]);

                // If u is an articulation point,
                // pop all edges from stack till u -- v
                if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                    Set<Integer> set = new HashSet<>();
                    while (true) {
                        Edge edge = st.pollLast();
                        set.add(edge.u);
                        set.add(edge.v);
                        if (edge.u == u && edge.v == v) break;
                    }
                    ans.add(set);
                    count++;
                }
            }

            // Update low value of 'u' only if 'v' is still in stack
            // (i.e. it's a back edge, not cross edge).
            else if (v != parent[u] && disc[v] < disc[u]) {
                if (low[u] > disc[v])
                    low[u] = disc[v];
                st.add(new Edge(u, v));
            }
        }
    }

    private static class Edge {
        int u, v;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u &&
                    v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}

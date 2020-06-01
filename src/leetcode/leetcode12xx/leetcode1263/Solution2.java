package leetcode.leetcode12xx.leetcode1263;

import java.util.*;

public class Solution2 {
    private static final int[][] moves = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static int encode(int bx, int by, int move) {
        return (bx << 16) | (by << 8) | move;
    }

    private static int[] decode(int num) {
        int[] ret = new int[3];
        ret[0] = (num >>> 16) & 0xff;
        ret[1] = (num >>> 8) & 0xff;
        ret[2] = num & 0xff;
        return ret;
    }

    private static boolean isReachable(int src, int dest, int exclude, HashMap<Integer, Set<Integer>> nodeToComponent, List<Integer>[] adj) {
        if (src == dest) return true;
        Set<Integer> srcList = nodeToComponent.get(src);
        Set<Integer> destList = nodeToComponent.get(dest);
        for (Integer srcElem : srcList) {
            if (destList.contains(srcElem)) return true;
        }
        Set<Integer> excludeList = nodeToComponent.get(exclude);
        boolean[] visited = new boolean[adj.length];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(srcList.iterator().next(), false));
        Iterator<Integer> iterator = destList.iterator();
        Integer destComp = iterator.next();
        if (excludeList.contains(destComp) && iterator.hasNext()) destComp = iterator.next();
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            boolean b = excludeList.contains(poll.a);
            if (visited[poll.a] || (poll.b && b)) continue;
            visited[poll.a] = true;
            if (destComp == poll.a) return true;
            for (Integer next : adj[poll.a]) {
                queue.add(new Pair(next, poll.b | b));
            }
        }
        return false;
    }

    public int minPushBox(char[][] grid) {
        int[] box = null, target = null, sk = null;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') box = new int[]{i, j};
                else if (grid[i][j] == 'T') target = new int[]{i, j};
                else if (grid[i][j] == 'S') sk = new int[]{i, j};
            }
        }
        UndirectedGraph graph = new UndirectedGraph(m * n);
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sk[0]);
        queue.add(sk[1]);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int[] move : moves) {
                int nsx = x + move[0];
                int nsy = y + move[1];
                if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#') continue;
                graph.addEdge(x * n + y, nsx * n + nsy);
                queue.add(nsx);
                queue.add(nsy);
            }
        }
        if (visited[box[0]][box[1]] && visited[target[0]][target[1]] && visited[sk[0]][sk[1]]) {
            List<Set<Integer>> bcc = graph.bcc();
            HashMap<Integer, Set<Integer>> nToC = new HashMap<>();
            for (int i = bcc.size() - 1; i >= 0; i--) {
                for (Integer node : bcc.get(i)) {
                    Set<Integer> list = nToC.getOrDefault(node, new HashSet<>());
                    list.add(i);
                    nToC.put(node, list);
                }
            }
            List<Integer>[] adj = new List[bcc.size()];
            for (int i = 0; i < bcc.size(); i++) {
                adj[i] = new LinkedList<>();
            }
            for (Set<Integer> set : nToC.values()) {
                for (int u : set) {
                    for (int v : set) {
                        if (u != v) adj[u].add(v);
                    }
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < moves.length; i++) {
                int[] move = moves[i];
                int nbx = box[0] + move[0];
                int nby = box[1] + move[1];
                int nsx = box[0] - move[0];
                int nsy = box[1] - move[1];
                if (
                        nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#' ||
                                nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#' ||
                                !isReachable(sk[0] * n + sk[1], nsx * n + nsy, box[0] * n + box[1], nToC, adj)
                ) continue;
                int start = encode(box[0], box[1], i);
                q.offer(start);
                map.put(start, 0);

            }
            int ans = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int prevKey = q.poll();
                int prevDist = map.get(prevKey);
                if (prevDist >= ans) continue;
                int[] c = decode(prevKey);
                int sx = c[0];
                int sy = c[1];
                int bx = c[0] + moves[c[2]][0];
                int by = c[1] + moves[c[2]][1];
                if (bx == target[0] && by == target[1]) {
                    ans = Math.min(ans, prevDist + 1);
                    continue;
                }
                for (int i = 0; i < moves.length; i++) {
                    int[] move = moves[i];
                    int nbx = bx + move[0];
                    int nby = by + move[1];
                    int nsx = bx - move[0];
                    int nsy = by - move[1];
                    if (
                            nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#' ||
                                    nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#' ||
                                    !isReachable(sx * n + sy, nsx * n + nsy, bx * n + by, nToC, adj)
                    ) continue;
                    int nkey = encode(bx, by, i);
                    if (map.containsKey(nkey) && map.get(nkey) <= prevDist + 1) continue;
                    map.put(nkey, prevDist + 1);
                    q.offer(nkey);

                }
            }
            return ans != Integer.MAX_VALUE ? ans : -1;
        }
        return -1;
    }

    private static class UndirectedGraph {

        static int count = 0, time = 0;

        private List<Integer>[] adj;

        public UndirectedGraph(int n) {
            adj = new List[n];
        }

        public void addEdge(int u, int v) {
            if (adj[u] == null) adj[u] = new LinkedList<>();
            adj[u].add(v);
//            if (adj[v] == null) adj[v] = new LinkedList<>();
//            adj[v].add(u);
        }

        public List<Set<Integer>> bcc() {
            int n = adj.length;
            int[] disc = new int[n];
            int[] low = new int[n];
            int[] parent = new int[n];

            LinkedList<Edge> st = new LinkedList<>();
            List<Set<Integer>> ansComponents = new ArrayList<>();

            Arrays.fill(disc, -1);
            Arrays.fill(low, -1);
            Arrays.fill(parent, -1);
            for (int i = 0; i < n; i++) {
                if (adj[i] == null) continue;
                ;
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

        private void bccUtil(int u, int[] disc, int[] low, LinkedList<Edge> st, int[] parent, List<Set<Integer>> ans) {
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

    }

    private static class Edge {

        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

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

    }

    private static class Pair {
        int a;
        boolean b;

        public Pair(int a, boolean b) {
            this.a = a;
            this.b = b;
        }
    }
}

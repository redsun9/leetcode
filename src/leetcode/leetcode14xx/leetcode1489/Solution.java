package leetcode.leetcode14xx.leetcode1489;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int length = edges.length;
        if (length == 0) return Arrays.asList(Collections.emptyList(), Collections.emptyList());
        UnionFind uf = new UnionFind(n);
        Integer[] edgesOrder = new Integer[length];
        for (int i = 0; i < length; i++) edgesOrder[i] = i;
        Arrays.sort(edgesOrder, comparingInt(x -> edges[x][2]));
        List<Integer> critical = new LinkedList<>();
        Set<Integer> pseudoCritical = new HashSet<>();
        int start = 0;
        while (start < length) {
            int curValue = edges[edgesOrder[start]][2];
            int end = start + 1;
            while (end < length && edges[edgesOrder[end]][2] == curValue) end++;

            if (end - start == 1) {
                Integer edgeIndex = edgesOrder[start];
                if (uf.find(edges[edgeIndex][0]) != uf.find(edges[edgeIndex][1])) {
                    critical.add(edgeIndex);
                    uf.union(edges[edgeIndex][0], edges[edgeIndex][1]);
                }
            } else {
                HashMap<Integer, Set<Integer>> setToEdges = new HashMap<>();
                HashMap<Integer, Integer> pointToUnionBefore = new HashMap<>();
                for (int i = start; i < end; i++) {
                    Integer edgeIndex = edgesOrder[i];
                    int[] edge = edges[edgeIndex];
                    int from = uf.find(edge[0]);
                    int to = uf.find(edge[1]);
                    pointToUnionBefore.put(edge[0], from);
                    pointToUnionBefore.put(edge[1], to);
                    if (from != to) {
                        Set<Integer> fromSet = setToEdges.getOrDefault(from, new HashSet<>());
                        fromSet.add(edgeIndex);
                        setToEdges.put(from, fromSet);
                        Set<Integer> toSet = setToEdges.getOrDefault(to, new HashSet<>());
                        toSet.add(edgeIndex);
                        setToEdges.put(to, toSet);
                    }
                }
                PriorityQueue<Set<Integer>> pq = new PriorityQueue<>(comparingInt(Set::size));
                pq.addAll(setToEdges.values());
                while (!pq.isEmpty() && pq.peek().size() == 1) {
                    Set<Integer> entry = pq.peek();
                    Integer edgeIndex = entry.iterator().next();
                    int[] edge = edges[edgeIndex];
                    Set<Integer> first = setToEdges.get(pointToUnionBefore.get(edge[0]));
                    Set<Integer> second = setToEdges.get(pointToUnionBefore.get(edge[1]));
                    pq.remove(first);
                    pq.remove(second);
                    first.remove(edgeIndex);
                    second.remove(edgeIndex);
                    if (!first.isEmpty()) pq.offer(first);
                    if (!second.isEmpty()) pq.offer(second);
                    critical.add(edgeIndex);
                    uf.union(edge[0], edge[1]);
                }
                if (!pq.isEmpty()) {
                    Set<Integer> edgeSet = new HashSet<>();
                    for (Set<Integer> set : pq) edgeSet.addAll(set);
                    int minUnionSize = numberOfUnionsAfterAdd(uf, n, edgeSet, edges, null);

                    for (Integer edgeIndex : edgeSet) {
                        if (numberOfUnionsAfterAdd(uf, n, edgeSet, edges, edgeIndex) > minUnionSize)
                            critical.add(edgeIndex);
                        else pseudoCritical.add(edgeIndex);
                    }
                    for (Integer edgeIndex : edgeSet) uf.union(edges[edgeIndex][0], edges[edgeIndex][1]);
                }
            }
            start = end;
        }
        return Arrays.asList(critical, new ArrayList<>(pseudoCritical));
    }

    private static int numberOfUnionsAfterAdd(UnionFind uf, int n, Set<Integer> edgeSet, int[][] edges, Integer edgeToSkip) {
        UnionFind tuf = new UnionFind(uf);
        for (Integer edgeIndex : edgeSet)
            if (!edgeIndex.equals(edgeToSkip)) tuf.union(edges[edgeIndex][0], edges[edgeIndex][1]);
        HashSet<Integer> unions = new HashSet<>();
        for (int i = 0; i < n; i++) unions.add(tuf.find(i));
        return unions.size();
    }


    private static class UnionFind {
        private final int n;
        private final int p[], rank[];

        public UnionFind(int n) {
            this.n = n;
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public UnionFind(UnionFind uf) {
            this.n = uf.n;
            this.p = Arrays.copyOf(uf.p, n);
            this.rank = Arrays.copyOf(uf.rank, n);
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

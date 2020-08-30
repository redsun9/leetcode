package leetcode.leetcode9xx.leetcode952;

import java.util.*;

public class Solution {
    private static final int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313, 317
    };

    public int largestComponentSize(int[] a) {
        int n = a.length;
        if (n <= 1) return n;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int j = 0;
            while (tmp != 1 && primes[j] * primes[j] <= tmp) {
                if (tmp % primes[j] == 0) {
                    List<Integer> list = map.getOrDefault(primes[j], new LinkedList<>());
                    list.add(i);
                    map.put(primes[j], list);
                    while (tmp % primes[j] == 0) tmp /= primes[j];
                }
                j++;
            }
            if (tmp != 1) {
                List<Integer> list = map.getOrDefault(tmp, new LinkedList<>());
                list.add(i);
                map.put(tmp, list);
            }
        }

        UnionFind uf = new UnionFind(n);
        for (List<Integer> list : map.values()) {
            if (list.size() > 1) {
                Iterator<Integer> iterator = list.iterator();
                Integer u = iterator.next();
                while (iterator.hasNext()) {
                    uf.union(u, iterator.next());
                }
            }
        }
        return uf.max;
    }

    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    private static class UnionFind {
        private final int[] p;
        private final int[] rank;
        private final int[] size;
        private int max = 1;

        public UnionFind(int n) {
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
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
            if (rank[x] < rank[y]) {
                p[x] = y;
                size[y] += size[x];
                max = Math.max(max, size[y]);
            } else {
                p[y] = x;
                size[x] += size[y];
                max = Math.max(max, size[x]);
                if (rank[x] == rank[y])
                    ++rank[x];
            }
        }
    }
}

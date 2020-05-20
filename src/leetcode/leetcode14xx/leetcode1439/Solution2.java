package leetcode.leetcode14xx.leetcode1439;

import java.util.*;

//try with step by step expansion
@SuppressWarnings("ConstantConditions")
public class Solution2 {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        HashSet<Node> used = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.sum));

        int tmp = 0;
        for (int i = 0; i < m; i++) tmp += mat[i][0];
        Node node = new Node(new int[m], tmp);
        pq.offer(node);
        used.add(node);
        while (true) {
            Node p = pq.poll();
            int sum = p.sum;
            if (k == 1) return sum;
            k--;
            int[] idx = Arrays.copyOf(p.idx, m);
            for (int i = 0; i < m; i++) {
                if (idx[i] < n - 1) {
                    int newSum = sum - mat[i][idx[i]] + mat[i][idx[i] + 1];
                    idx[i]++;
                    Node o = new Node(idx, newSum);
                    if (!used.contains(o)) {
                        used.add(o);
                        pq.offer(o);
                        idx = Arrays.copyOf(p.idx, m);
                    } else {
                        idx[i]--;
                    }
                }
            }
        }
    }

    private static class Node {
        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + Arrays.toString(idx) +
                    ", sum=" + sum +
                    '}';
        }

        private final int[] idx;
        private final int sum;

        public Node(int[] idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return sum == node.sum &&
                    Arrays.equals(idx, node.idx);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(sum);
            result = 31 * result + Arrays.hashCode(idx);
            return result;
        }
    }
}

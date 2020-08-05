package leetcode.leetcode5xx.leetcode559;

import leetcode.tools.Node;

import java.util.LinkedList;

/*
    iterative solution
*/
public class Solution2 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int ans = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int curDepth = pair.curDepth;
            ans = Math.max(ans, curDepth++);
            if (pair.root.children != null) {
                for (Node child : pair.root.children) {
                    queue.offer(new Pair(child, curDepth));
                }
            }
        }
        return ans;
    }

    private static class Pair {
        Node root;
        int curDepth;

        public Pair(Node root, int curDepth) {
            this.root = root;
            this.curDepth = curDepth;
        }
    }
}

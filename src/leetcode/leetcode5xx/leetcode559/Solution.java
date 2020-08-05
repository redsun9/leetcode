package leetcode.leetcode5xx.leetcode559;

import leetcode.tools.Node;

/*
    recursive solution
*/
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        int ans = 0;
        for (Node child : root.children) {
            ans = Math.max(ans, maxDepth(child));
        }
        return ans + 1;
    }
}

package leetcode.leetcode1xx.leetcode106;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) inMap.put(inorder[i], i);
        TreeNode[] nodes = new TreeNode[n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, n - 1, n - 1});
        while (!stack.isEmpty()) {
            int[] peek = stack.peek();
            int iStart = peek[0];
            int iEnd = peek[1];
            int rootIdx = peek[2];
            Integer iRoot = inMap.get(postorder[rootIdx]);
            if (nodes[rootIdx] == null) {
                nodes[rootIdx] = new TreeNode(postorder[rootIdx]);
                if (iStart < iRoot) stack.push(new int[]{iStart, iRoot - 1, rootIdx - iEnd + iRoot - 1});
                if (iRoot < iEnd) stack.push(new int[]{iRoot + 1, iEnd, rootIdx - 1});
            } else {
                stack.pop();
                if (iStart < iRoot) nodes[rootIdx].left = nodes[rootIdx - iEnd + iRoot - 1];
                if (iRoot < iEnd) nodes[rootIdx].right = nodes[rootIdx - 1];
            }
        }
        return nodes[n - 1];
    }
}

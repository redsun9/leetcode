package leetcode.leetcode1xx.leetcode106;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static TreeNode buildTree(
            Map<Integer, Integer> map, int[] postorder,
            int iStart, int iEnd, int pEnd
    ) {
        if (iStart > iEnd) return null;
        Integer iRoot = map.get(postorder[pEnd]);
        return new TreeNode(
                postorder[pEnd],
                buildTree(map, postorder, iStart, iRoot - 1, pEnd - iEnd + iRoot - 1),
                buildTree(map, postorder, iRoot + 1, iEnd, pEnd - 1)
        );
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) inMap.put(inorder[i], i);
        return buildTree(inMap, postorder, 0, n - 1, n - 1);
    }
}

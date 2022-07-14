package leetcode.leetcode1xx.leetcode105;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i = 0; i < n; i++) iMap.put(inorder[i], i);
        return dfs(0, n, 0, n, preorder, iMap);
    }

    private static TreeNode dfs(
            int pLeft, int pRight, int iLeft, int iRight,
            int[] preorder,
            Map<Integer, Integer> iMap
    ) {
        if (pLeft == pRight) return null;
        int val = preorder[pLeft]; // value of root
        int iMid = iMap.get(val); // [inOrderLeft; inOrderMid) - left, (inrOrderMid;inOrderRight) - right
        int lSize = iMid - iLeft, rSize = iRight - iMid - 1;

        return new TreeNode(
                val,
                dfs(pLeft + 1, pLeft + 1 + lSize, iLeft, iMid, preorder, iMap),
                dfs(pRight - rSize, pRight, iMid + 1, iRight, preorder, iMap)
        );
    }
}

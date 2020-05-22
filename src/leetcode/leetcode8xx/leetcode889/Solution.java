package leetcode.leetcode8xx.leetcode889;

import leetcode.tools.TreeNode;

import java.util.HashMap;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        HashMap<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            preMap.put(pre[i], i);
            postMap.put(post[i], i);
        }
        return construct(pre, 0, n, post, 0, n, preMap, postMap);
    }

    private static TreeNode construct(
            int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd,
            HashMap<Integer, Integer> preMap, HashMap<Integer, Integer> postMap
    ) {
        if (preStart == preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preEnd == preStart + 1) {
            return root;
        } else if (pre[preStart + 1] == post[postEnd - 2]) {
            root.left = construct(pre, preStart + 1, preEnd, post, postStart, postEnd - 1, preMap, postMap);
            return root;
        } else {
            Integer postMid = postMap.get(pre[preStart + 1]);
            Integer preMid = preMap.get(post[postEnd - 2]);
            root.left = construct(pre, preStart + 1, preMid, post, postStart, postMid + 1, preMap, postMap);
            root.right = construct(pre, preMid, preEnd, post, postMid + 1, postEnd - 1, preMap, postMap);
            return root;
        }
    }
}

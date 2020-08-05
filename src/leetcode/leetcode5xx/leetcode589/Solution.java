package leetcode.leetcode5xx.leetcode589;

import leetcode.tools.Node;

import java.util.LinkedList;
import java.util.List;

/*
    recursive solution
*/
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(Node root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            if (root.children != null) {
                root.children.forEach(child -> dfs(child, ans));
            }
        }
    }
}

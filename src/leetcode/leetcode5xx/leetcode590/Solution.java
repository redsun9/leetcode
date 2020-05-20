package leetcode.leetcode5xx.leetcode590;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        postorder(root, ans);
        return ans;
    }

    private static void postorder(Node root, List<Integer> ans) {
        if (root != null) {
            if (root.children != null) {
                for (Node child : root.children) {
                    postorder(child, ans);
                }
            }
            ans.add(root.val);
        }
    }
}

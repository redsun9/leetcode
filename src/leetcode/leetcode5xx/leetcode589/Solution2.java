package leetcode.leetcode5xx.leetcode589;

import leetcode.tools.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
    iterative solution
*/
public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }
            }
        }
        return ans;
    }
}

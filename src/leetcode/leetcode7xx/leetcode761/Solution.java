package leetcode.leetcode7xx.leetcode761;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//using tree and stack

public class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 2) return s;
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                Node child = new Node();
                root.children.add(child);
                stack.push(root);
                root = child;
            } else {
                //sort children, calculate val, size
                root.calcVal();
                root = stack.pop();
            }
        }
        root.calcVal();
        return root.val.substring(1, root.val.length() - 1);
    }

    private static class Node {
        String val = "";
        List<Node> children = new ArrayList<>();

        private void calcVal() {
            children.sort((a, b) -> (b.val + a.val).compareTo(a.val + b.val));
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            children.forEach(x -> sb.append(x.val));
            sb.append("0");
            val = sb.toString();
        }
    }
}

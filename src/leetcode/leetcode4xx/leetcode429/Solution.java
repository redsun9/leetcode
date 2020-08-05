package leetcode.leetcode4xx.leetcode429;

import leetcode.tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(curLevelSize);
            for (int i = 0; i < curLevelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            ans.add(currentLevel);
        }
        return ans;
    }
}

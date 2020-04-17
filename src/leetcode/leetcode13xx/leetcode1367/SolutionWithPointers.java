package leetcode.leetcode13xx.leetcode1367;

import leetcode.tools.ListNode;
import leetcode.tools.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionWithPointers {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<ProcessNode> queue = new LinkedList<>();
        queue.add(new ProcessNode(root, Collections.emptyList()));
        while (!queue.isEmpty()) {
            ProcessNode poll = queue.poll();
            LinkedList<ListNode> listNodes = new LinkedList<>();
            for (ListNode listNode : poll.heads) {
                if (poll.root.val == listNode.val) {
                    if (listNode.next == null) return true;
                    listNodes.add(listNode.next);
                }
            }
            if (poll.root.val == head.val) {
                if (head.next == null) return true;
                listNodes.add(head.next);
            }

            if (poll.root.left != null) {
                queue.add(new ProcessNode(poll.root.left, listNodes));
            }
            if (poll.root.right != null) {
                queue.add(new ProcessNode(poll.root.right, listNodes));
            }

        }
        return false;
    }

    private static class ProcessNode {
        TreeNode root;
        List<ListNode> heads;

        public ProcessNode(TreeNode root, List<ListNode> heads) {
            this.root = root;
            this.heads = heads;
        }
    }
}

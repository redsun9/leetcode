package leetcode.leetcode13xx.leetcode1367;

import leetcode.tools.ListNode;
import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionWithTrie {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Trie trie = new Trie();
        trie.children = new HashMap<>();
        Queue<ProcessNode> queue = new LinkedList<>();
        queue.add(new ProcessNode(trie, root));
        while (!queue.isEmpty()) {
            ProcessNode poll = queue.poll();
            int val = poll.root.val;
            if (poll.trie.children == null) poll.trie.children = new HashMap<>();
            Trie subTree = poll.trie.children.getOrDefault(val, new Trie());
            poll.trie.children.put(val, subTree);
            if (poll.root.left != null) queue.add(new ProcessNode(subTree, poll.root.left));
            if (poll.root.right != null) queue.add(new ProcessNode(subTree, poll.root.right));

            Trie fromRoot = trie.children.getOrDefault(poll.root.val, new Trie());
            trie.children.put(val, fromRoot);
            if (poll.root.left != null) queue.add(new ProcessNode(fromRoot, poll.root.left));
            if (poll.root.right != null) queue.add(new ProcessNode(fromRoot, poll.root.right));
        }
        while (true) {
            if (head == null) return true;
            if (trie == null || trie.children == null) return false;
            trie = trie.children.get(head.val);
            head = head.next;
        }
    }

    private static class ProcessNode {
        Trie trie;
        TreeNode root;

        public ProcessNode(Trie trie, TreeNode root) {
            this.trie = trie;
            this.root = root;
        }
    }

    private static class Trie {
        HashMap<Integer, Trie> children;
    }
}

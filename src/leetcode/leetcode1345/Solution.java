package leetcode.leetcode1345;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, LinkedList<Integer>> same = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!same.containsKey(arr[i])) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                same.put(arr[i], list);
            } else {
                same.get(arr[i]).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new ArrayDeque<>(n);
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.value]) continue;
            visited[node.value] = true;
            if (node.value == n - 1) return node.length;
            if (node.value > 0) queue.offer(new Node(node.value - 1, node.length + 1));
            if (node.value < n - 1) queue.offer(new Node(node.value + 1, node.length + 1));
            LinkedList<Integer> removed = same.remove(arr[node.value]);
            if (removed != null) {
                removed.forEach(index -> queue.offer(new Node(index, node.length + 1)));
            }
        }
        return -1;
    }

    public static class Node {
        int value;
        int length;

        public Node(int value, int length) {
            this.value = value;
            this.length = length;
        }
    }
}

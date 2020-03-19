package leetcode.leetcode127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>>[] neighbours = new List[n];
        Node[] nodes = new Node[n];
        int length = beginWord.length();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
            Node node = new Node();
            node.index = i;
            nodes[i] = node;
            String str = wordList.get(i);
            if (!found && endWord.equals(str)) {
                found = true;
                node.isEndWord = true;
            }
            char[] chars = str.toCharArray();
            for (int j = 0; j < length; j++) {
                char c = chars[j];
                chars[j] = '?';
                String s = new String(chars);
                if (!hashMap.containsKey(s)) {
                    hashMap.put(s, new LinkedList<>());
                }
                List<Integer> integers = hashMap.get(s);
                integers.add(i);
                neighbours[i].add(integers);
                chars[j] = c;
            }
        }
        if (!found) return 0;
        Queue<Node> queue = new ArrayDeque<>();
        char[] beginWordChars = beginWord.toCharArray();
        for (int i = 0; i < length; i++) {
            char c = beginWordChars[i];
            beginWordChars[i] = '?';
            String str = new String(beginWordChars);
            beginWordChars[i] = c;
            List<Integer> list = hashMap.get(str);
            if (list != null) {
                for (Integer integer : list) {
                    Node node = nodes[integer];
                    node.pathLength = 2;
                    queue.offer(node);
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!node.isEndWord) {
                for (List<Integer> list : neighbours[node.index]) {
                    for (Integer integer : list) {
                        Node neighbour = nodes[integer];
                        if (node.index != integer && (neighbour.pathLength == -1 || neighbour.pathLength == node.pathLength + 1)) {
                            if (neighbour.pathLength == -1) {
                                queue.add(neighbour);
                            }
                            neighbour.pathLength = node.pathLength + 1;
                        }
                    }
                }
            } else {
                return node.pathLength;
            }
        }
        return 0;
    }

    private static class Node {
        int index;
        boolean isEndWord;
        int pathLength = -1;
    }
}

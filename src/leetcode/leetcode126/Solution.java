package leetcode.leetcode126;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>>[] neighbours = new List[n];
        Node[] nodes = new Node[n];
        int length = beginWord.length();
        boolean found = false;
        Integer endWordIndex = null;
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
            Node node = new Node();
            node.index = i;
            nodes[i] = node;
            String str = wordList.get(i);
            if (!found && endWord.equals(str)) {
                found = true;
                node.isEndWord = true;
                endWordIndex = i;
                LinkedList<String> list = new LinkedList<>();
                list.add(endWord);
                node.result.add(list);
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
        if (endWordIndex == null) return Collections.emptyList();
        Queue<Node> queue = new ArrayDeque<>();
        char[] beginWordChars = beginWord.toCharArray();
        LinkedList<List<String>> result = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = beginWordChars[i];
            beginWordChars[i] = '?';
            String str = new String(beginWordChars);
            beginWordChars[i] = c;
            List<Integer> list = hashMap.get(str);
            if (list != null) {
                for (Integer integer : list) {
                    Node node = nodes[integer];
                    node.pathLength = 0;
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
                            neighbour.from.add(node.index);
                            neighbour.pathLength = node.pathLength + 1;
                        }
                    }
                }
            }
        }
        Node endNode = nodes[endWordIndex];
        if (endNode.pathLength == -1) return Collections.emptyList();
        queue.add(endNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!node.processed) {
                node.processed = true;
                if (node.pathLength == 0) {
                    node.result.forEach(l -> l.add(0, beginWord));
                    result.addAll(node.result);
                } else {
                    for (Integer integer : node.from) {
                        Node neighbour = nodes[integer];
                        String s = wordList.get(integer);
                        for (List<String> path : node.result) {
                            LinkedList<String> newPath = new LinkedList<>(path);
                            newPath.addFirst(s);
                            neighbour.result.add(newPath);
                        }
                        queue.add(neighbour);
                    }
                }
            }
        }
        return result;
    }

    private static class Node {
        int index;
        boolean isEndWord;
        boolean processed = false;
        List<Integer> from = new LinkedList<>();
        int pathLength = -1;
        List<List<String>> result = new LinkedList<>();
    }
}

package leetcode.leetcode10xx.leetcode1048;

import java.util.*;

public class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        if (n <= 1) return n;
        HashSet<Integer> lengths = new HashSet<>();
        for (String word : words) lengths.add(word.length());
        HashMap<String, Integer> wordMaps = new HashMap<>();
        for (int i = 0; i < words.length; i++) wordMaps.put(words[i], i);
        HashMap<Integer, Collection<Integer>> edges = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!lengths.contains(word.length() - 1)) continue;
            for (int j = 0; j < word.length(); j++) {
                String prev = word.substring(0, j) + word.substring(j + 1);
                if (wordMaps.containsKey(prev)) {
                    Integer prevIndex = wordMaps.get(prev);
                    Collection<Integer> list = edges.getOrDefault(prevIndex, new LinkedList<>());
                    list.add(i);
                    edges.put(prevIndex, list);
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[i] != 0) continue;
            stack.push(i);
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                Collection<Integer> neigbours = edges.getOrDefault(peek, Collections.emptyList());
                if (dp[peek] == 0) {
                    dp[peek] = 1;
                    for (Integer neighbour : neigbours) if (dp[neighbour] == 0) stack.push(neighbour);
                } else {
                    int max = 0;
                    for (Integer neighbour : neigbours) max = Math.max(max, dp[neighbour]);
                    dp[peek] = max + 1;
                    stack.pop();
                }
            }
        }
        int ans = 0;
        for (int a : dp) ans = Math.max(ans, a);
        return ans;
    }
}

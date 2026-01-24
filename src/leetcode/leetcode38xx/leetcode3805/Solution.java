package leetcode.leetcode38xx.leetcode3805;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long countPairs(String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.addString(word);
        return trie.countPairs();
    }

    private static class Trie {
        List<int[]> child;
        List<Integer> count;
        int nxt = 1;

        Trie() {
            child = new ArrayList<>();
            count = new ArrayList<>();
            child.add(new int[26]);
            count.add(0);
        }

        void addString(String s) {
            int node = 0, n = s.length();
            for (int i = 1; i < n; i++) {
                int k = s.charAt(i - 1) - s.charAt(i);
                if (k < 0) k += 26;

                if (child.get(node)[k] == 0) {
                    child.get(node)[k] = nxt++;
                    child.add(new int[26]);
                    count.add(0);
                }
                node = child.get(node)[k];
            }
            count.set(node, count.get(node) + 1);
        }

        long countPairs() {
            long ans = 0;
            for (Integer c : count) ans += c * (c - 1L);
            return ans / 2;
        }
    }
}

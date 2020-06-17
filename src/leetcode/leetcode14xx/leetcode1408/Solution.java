package leetcode.leetcode14xx.leetcode1408;

import java.util.LinkedList;
import java.util.List;

//using trie with count
public class Solution {
    public List<String> stringMatching(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                Trie cur = root;
                for (int j = i; j < n; j++) {
                    int c = word.charAt(j) - 'a';
                    if (cur.children[c] == null) cur.children[c] = new Trie();
                    cur = cur.children[c];
                    cur.count++;
                }
            }
        }
        //now check
        List<String> ans = new LinkedList<>();
        for (String word : words) {
            int n = word.length();
            Trie cur = root;
            for (int i = 0; i < n; i++) {
                cur = cur.children[word.charAt(i) - 'a'];
            }
            if (cur.count > 1) ans.add(word);
        }
        return ans;
    }


    private static class Trie {
        int count = 0;
        Trie[] children = new Trie[26];
    }
}

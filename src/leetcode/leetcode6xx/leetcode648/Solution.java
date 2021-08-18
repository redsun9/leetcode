package leetcode.leetcode6xx.leetcode648;

import java.util.List;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        int max = 1;
        for (String s : dictionary) max += s.length();
        int[][] child = new int[max][26];
        int[] index = new int[max];
        int nxt = 1;
        int n = dictionary.size();
        for (int i = 0; i < n; i++) {
            String word = dictionary.get(i);
            int len = word.length();
            int node = 0;
            for (int j = 0; j < len; j++) {
                int c = word.charAt(j) - 'a';
                if (child[node][c] == 0) {
                    child[node][c] = nxt++;
                    node = child[node][c];
                } else {
                    node = child[node][c];
                    if (index[node] != 0) break;
                }
            }
            if (index[node] == 0) index[node] = i + 1;
        }
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : parts) {
            int len = word.length();
            int node = 0;
            for (int j = 0; j < len; j++) {
                int c = word.charAt(j) - 'a';
                node = child[node][c];
                if (node == 0 || index[node] != 0) break;
            }
            if (node != 0 && index[node] != 0) sb.append(' ').append(dictionary.get(index[node] - 1));
            else sb.append(' ').append(word);
        }

        return sb.substring(1);
    }
}

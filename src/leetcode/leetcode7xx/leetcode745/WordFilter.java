package leetcode.leetcode7xx.leetcode745;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    private final List<int[]> child;
    private final int[] indices;

    public WordFilter(String[] words) {
        int max = 1 + words.length * 176;
        child = new ArrayList<>();
        child.add(new int[27]);
        indices = new int[max];
        int nxt = 1;
        for (int index = 0; index < words.length; index++) {
            String str = words[index];
            int n = str.length();
            for (int suffixLength = 0; suffixLength <= n; suffixLength++) {
                int node = 0;
                for (int i = n - suffixLength; i < n; i++) {
                    int c = str.charAt(i) - 'a';
                    if (child.get(node)[c] == 0) {
                        child.add(new int[27]);
                        child.get(node)[c] = nxt++;
                    }
                    node = child.get(node)[c];
                }
                //add separator
                if (child.get(node)[26] == 0) {
                    child.add(new int[27]);
                    child.get(node)[26] = nxt++;
                }
                node = child.get(node)[26];
                indices[node] = index;

                for (int i = 0; i < n; i++) {
                    int c = str.charAt(i) - 'a';
                    if (child.get(node)[c] == 0) {
                        child.add(new int[27]);
                        child.get(node)[c] = nxt++;
                    }
                    node = child.get(node)[c];
                    indices[node] = index;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        int node = 0;
        for (int i = 0; i < suffix.length(); i++) {
            int c = suffix.charAt(i) - 'a';
            if (child.get(node)[c] == 0) return -1;
            node = child.get(node)[c];
        }
        if (child.get(node)[26] == 0) return -1;
        node = child.get(node)[26];
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (child.get(node)[c] == 0) return -1;
            node = child.get(node)[c];
        }
        return indices[node];
    }
}

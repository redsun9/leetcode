package leetcode.leetcode18xx.leetcode1807;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        List<int[]> child = new ArrayList<>();
        List<String> word = new ArrayList<>();
        child.add(new int[26]);
        word.add(null);
        for (List<String> pair : knowledge) {
            String key = pair.get(0);
            String val = pair.get(1);
            int node = 0;
            for (int i = 0; i < key.length(); i++) {
                int c = key.charAt(i) - 'a';
                if (child.get(node)[c] == 0) {
                    child.get(node)[c] = child.size();
                    child.add(new int[26]);
                    word.add(null);
                }
                node = child.get(node)[c];
            }
            word.set(node, val);
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) != '(') sb.append(s.charAt(i++));
            if (i != n) {
                boolean ok = true;
                int node = 0;
                i++;
                while (s.charAt(i) != ')') {
                    if (ok) {
                        int c = s.charAt(i) - 'a';
                        node = child.get(node)[c];
                        if (node == 0) ok = false;
                    }
                    i++;
                }
                if (ok && word.get(node) != null) sb.append(word.get(node));
                else sb.append('?');
                i++;
            }
        }
        return sb.toString();
    }
}

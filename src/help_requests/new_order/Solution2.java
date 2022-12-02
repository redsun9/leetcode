package help_requests.new_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    private static final int ALPHABET_SIZE = 26;

    public static String[] sortWithNewAlphabetOrder(String[] strings, String x) {
        Trie trie = new Trie();
        for (String string : strings) trie.addString(string);
        return trie.getSortedWithNewOrder(x);
    }

    private static class Trie {
        final List<int[]> child = new ArrayList<>();
        final List<String> words = new ArrayList<>();
        final List<Integer> cntWords = new ArrayList<>();
        int nxt = 1, totalWords = 0;

        public Trie() {
            child.add(new int[26]);
            words.add(null);
            cntWords.add(0);
        }

        public void addString(String str) {
            totalWords++;
            int node = 0;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                if (child.get(node)[c] == 0) {
                    child.get(node)[c] = nxt++;
                    child.add(new int[ALPHABET_SIZE]);
                    words.add(null);
                    cntWords.add(0);
                }
                node = child.get(node)[c];
            }
            words.set(node, str);
            cntWords.set(node, cntWords.get(node) + 1);
        }

        public String[] getSortedWithNewOrder(String order) {
            String[] ans = new String[totalWords];
            dfs(0, 0, order, ans);
            return ans;
        }

        private int dfs(int node, int alreadyReadWords, String order, String[] ans) {
            Arrays.fill(ans, alreadyReadWords, alreadyReadWords + cntWords.get(node), words.get(node));
            alreadyReadWords += cntWords.get(node);
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                int c = order.charAt(i) - 'a';
                if (child.get(node)[c] != 0) alreadyReadWords = dfs(child.get(node)[c], alreadyReadWords, order, ans);
            }
            return alreadyReadWords;
        }
    }
}

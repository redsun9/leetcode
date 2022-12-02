package help_requests.new_order;


import java.util.Arrays;
import java.util.Stack;

public class Solution3 {
    private static final int ALPHABET_SIZE = 26;

    public static String[] sortWithNewAlphabetOrder(String[] strings, String order) {
        TrieNode trie = new TrieNode();
        for (String string : strings) trie.addString(string);
        trie.getSorted(order, strings);
        return strings;
    }

    private static class TrieNode {
        final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        String string = null;
        int count = 0;

        public void addString(String str) {
            int n = str.length();
            TrieNode node = this;
            for (int i = 0; i < n; i++) {
                int c = str.charAt(i) - 'a';
                if (node.children[c] == null) node.children[c] = new TrieNode();
                node = node.children[c];
            }
            node.string = str;
            node.count++;
        }

        public void getSorted(String order, String[] ans) {
            int pos = 0;
            Stack<TrieNode> stack = new Stack<>();
            stack.push(this);
            while (!stack.isEmpty()) {
                TrieNode node = stack.pop();
                Arrays.fill(ans, pos, pos + node.count, node.string);
                pos += node.count;
                for (int i = ALPHABET_SIZE - 1; i >= 0; i--) {
                    int c = order.charAt(i) - 'a';
                    if (node.children[c] != null) stack.push(node.children[c]);
                }
            }
        }
    }
}

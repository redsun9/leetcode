package leetcode.leetcode8xx.leetcode820;


public class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) return 0;
        if (words.length == 1) return words[0].length() + 1;
        Trie root = new Trie();
        for (String word : words) {
            Trie tmp = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (tmp.children == null) tmp.children = new Trie[26];
                if (tmp.children[c] == null) tmp.children[c] = new Trie();
                tmp = tmp.children[c];
            }
        }
        return dfs(root, 0);
    }

    private static int dfs(Trie root, int depth) {
        if (root.children == null) return depth + 1;
        int ans = 0;
        for (Trie child : root.children) {
            if (child != null) ans += dfs(child, depth + 1);
        }
        return ans;
    }


    private static class Trie {
        Trie[] children;
    }
}

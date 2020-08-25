package basic;

public class Trie {
    int[][] child;
    boolean[] isWord;
    int nxt = 1;

    public Trie(int max) {
        child = new int[max][26];
        isWord = new boolean[max];
    }

    public void addString(String str) {
        int node = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if (child[node][c] == 0) child[node][c] = nxt++;
            node = child[node][c];
        }
        isWord[node] = true;
    }

    public boolean containsPrefix(String str) {
        int node = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if (child[node][c] == 0) return false;
            node = child[node][c];
        }
        return isWord[node];
    }
}

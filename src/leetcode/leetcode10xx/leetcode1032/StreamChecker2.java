package leetcode.leetcode10xx.leetcode1032;

import java.util.LinkedList;
import java.util.List;

// slower on leetcode tests than another solution
public class StreamChecker2 {
    public static final int MAX_SIZE = 50_000;
    private final int[][] child;
    private final boolean[] isWord;
    private List<Integer> state;

    public StreamChecker2(String[] words) {
        int nxt = 1;
        child = new int[MAX_SIZE][26];
        isWord = new boolean[MAX_SIZE];
        for (String str : words) {
            int n = str.length();
            int node = 0;
            for (int i = 0; i < n; i++) {
                int c = str.charAt(i) - 'a';
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
            }
            isWord[node] = true;
        }
        state = List.of(0);
    }

    public boolean query(char letter) {
        int c = letter - 'a';
        List<Integer> newState = new LinkedList<>();
        boolean ans = false;
        for (int node : state) {
            int next = child[node][c];
            if (next != 0) {
                newState.add(next);
                ans |= isWord[next];
            }
        }
        newState.add(0);
        state = newState;
        return ans;
    }
}

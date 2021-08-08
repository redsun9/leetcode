package suggestions.boolean_satisfiability;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int n = 26;

    public boolean equationsPossible(String[] equations) {
        boolean[][] same = new boolean[n][n];
        boolean[][] diff = new boolean[n][n];
        int[] color = new int[n];
        for (String equation : equations) {
            int u = equation.charAt(0) - 'a', v = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!') {
                diff[u][v] = true;
                diff[v][u] = true;
            } else {
                same[u][v] = true;
                same[v][u] = true;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            queue.add(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v = 0; v < n; v++) {
                    if (same[u][v]) {
                        if (color[v] == 3 - color[u]) return false;
                        if (color[v] == 0) {
                            queue.add(v);
                            color[v] = color[u];
                        }
                    }
                    if (diff[u][v]) {
                        if (color[v] == color[u]) return false;
                        if (color[v] == 0) {
                            queue.add(v);
                            color[v] = 3 - color[u];
                        }
                    }
                }
            }
        }
        return true;
    }
}

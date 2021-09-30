package leetcode.leetcode2xx.leetcode277;

import java.util.Random;

public class Relation {
    int ans, n;
    boolean[][] mat;

    public Relation(int ans, int n, long seed) {
        this.ans = ans;
        this.n = n;
        mat = new boolean[n][n];
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (j == ans || i != ans && random.nextBoolean()) mat[i][j] = true;
            }
        }
    }

    public Relation() {
    }

    public boolean knows(int a, int b) {
        return mat[a][b];
    }
}

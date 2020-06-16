package leetcode.leetcode14xx.leetcode1483;

public class TreeAncestor {
    private final int[][] ancestors;
    private final int maxPower;
    private final int n;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        int maxPower = 0;
        int tmp = n;
        while (tmp > 0) {
            maxPower++;
            tmp >>>= 1;
        }
        this.maxPower = maxPower;
        ancestors = new int[maxPower][n];
        System.arraycopy(parent, 0, ancestors[0], 0, n);
        for (int j = 1; j < maxPower; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestors[j - 1][i] == -1) ancestors[j][i] = -1;
                else ancestors[j][i] = ancestors[j - 1][ancestors[j - 1][i]];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (node < 0 || node >= n || k <= 0 || k >= n) return -1;
        int tmp = node;
        for (int i = 0; i < maxPower; i++) {
            if ((k & (1 << i)) != 0) {
                tmp = ancestors[i][tmp];
                if (tmp == -1) return -1;
            }
        }
        return tmp;
    }
}

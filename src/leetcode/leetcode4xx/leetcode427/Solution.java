package leetcode.leetcode4xx.leetcode427;

public class Solution {
    private static final Node[] nodes = {
            new Node(false, true),
            new Node(true, true),
    };

    private static Node construct(int[][] grid, int i1, int i2, int j1, int j2) {
        if (i2 - i1 == 1) return nodes[grid[i1][j1]];
        int midI = (i1 + i2) >> 1, midJ = (j1 + j2) >> 1;
        Node topLeft = construct(grid, i1, midI, j1, midJ);
        Node topRight = construct(grid, i1, midI, midJ, j2);
        Node bottomLeft = construct(grid, midI, i2, j1, midJ);
        Node bottomRight = construct(grid, midI, i2, midJ, j2);
        if (topLeft == topRight && topRight == bottomLeft && bottomLeft == bottomRight) return topLeft;
        return new Node(
                true, false,
                topLeft,
                topRight,
                bottomLeft,
                bottomRight
        );
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, n, 0, n);
    }
}

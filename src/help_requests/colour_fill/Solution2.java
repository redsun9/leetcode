package help_requests.colour_fill;

import java.util.Stack;

// DFS solution
// O(m*n) - time
// O(m*n) - space
public class Solution2 {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static int numberOfFills(int[][] mat) {
        int ans = 0, m = mat.length, n = mat[0].length, colour, x, y, newX, newY;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colour = mat[i][j];
                if (colour == 0) continue;
                ans++;
                stack.push(new int[]{i, j});
                mat[i][j] = 0;
                while (!stack.isEmpty()) {
                    int[] poll = stack.pop();
                    x = poll[0];
                    y = poll[1];
                    for (int k = 0; k < 4; k++) {
                        newX = x + moves[k];
                        newY = y + moves[k + 1];
                        if (newX < 0 || newX >= m || newY < 0 || newY >= n || mat[newX][newY] != colour) continue;
                        mat[newX][newY] = 0;
                        stack.push(new int[]{newX, newY});
                    }
                }
            }
        }
        return ans;
    }
}

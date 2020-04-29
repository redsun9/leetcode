package leetcode.leetcode0xx.leetcode85;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        Stack<Pair>[] stacks = new Stack[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char[] row = matrix[i];
            int width = 0;
            for (int j = 0; j < n; j++) {
                Stack<Pair> stack = stacks[j];
                if (row[j] == '1') {
                    width++;
                    int last = -1;
                    while (!stack.isEmpty() && stack.peek().width > width) {
                        Pair pair = stack.pop();
                        last = pair.start;
                        ans = Math.max(ans, pair.width * (i - pair.start));
                    }
                    if (last != -1) stack.push(new Pair(width, last));
                    else stack.push(new Pair(width, i));
                } else {
                    width = 0;
                    while (!stack.isEmpty()) {
                        Pair pair = stack.pop();
                        ans = Math.max(ans, pair.width * (i - pair.start));
                    }
                }
            }
        }
        for (Stack<Pair> stack : stacks) {
            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                ans = Math.max(ans, pair.width * (m - pair.start));
            }
        }
        return ans;

    }

    private static class Pair {
        int width;
        int start;

        public Pair(int width, int start) {
            this.width = width;
            this.start = start;
        }
    }
}

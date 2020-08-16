package leetcode.leetcode12xx.leetcode1275;

public class Solution {
    private static final String[] winners = {"A", "B"};

    public String tictactoe(int[][] moves) {
        if (moves.length < 5) return "Pending";
        int[][] rows = new int[2][3];
        int[][] cols = new int[2][3];
        int[] diag1 = new int[2];
        int[] diag2 = new int[2];

        for (int i = 0, p = 0; i < moves.length; i++, p = 1 - p) {
            int[] move = moves[i];
            if (++rows[p][move[0]] == 3) return winners[p];
            if (++cols[p][move[1]] == 3) return winners[p];
            if (move[0] == move[1]) {
                if (++diag1[p] == 3) return winners[p];
            }
            if (move[0] + move[1] == 2) {
                if (++diag2[p] == 3) return winners[p];
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}

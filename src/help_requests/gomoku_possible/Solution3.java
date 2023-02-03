package help_requests.gomoku_possible;

public class Solution3 {
    public static boolean isValidPosition(int[] board) {
        int n = board.length;
        int[] countTotal = new int[2];
        for (int val : board) if (val != 0) countTotal[val - 1] += 1;
        if (countTotal[0] != countTotal[1] && countTotal[0] != countTotal[1] + 1) return false;

        int[] countOfWins = new int[2];
        boolean haveSixOrMoreInARow = false;

        int prev = 0, count = 0;
        for (int val : board) {
            if (val != 0) {
                if (val == prev) {
                    count++;
                    if (count == 3) countOfWins[val - 1]++;
                    if (count == 6) haveSixOrMoreInARow = true;
                } else count = 1;
            } else count = 0;
            prev = val;
        }

        if (haveSixOrMoreInARow) return false;
        if (countOfWins[0] != 0 && countOfWins[1] != 0) return false;
        if (countOfWins[0] > 1 || countOfWins[1] > 1) return false;
        if (countOfWins[0] > 0 && countTotal[0] != countTotal[1] + 1) return false;
        if (countOfWins[1] > 0 && countTotal[1] != countTotal[0]) return false;
        return true;
    }
}

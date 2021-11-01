package suggestions.number_of_chess_positions;


// each piece simultaneously moves to another cell or remains in its position
// find all possible combinations of moves
// pieces don't block each other and can move through each other
// there can be at most one piece in each cell
// 0<pieces.length <=4
// piece[i] in {"king","rook","bishop","queen","knight")


public class Solution {
    private static final int boardSize = 8;
    private static final int[][] knightMoves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    private static final boolean DEBUG = true;

    public long countCombinations(String[] pieces, int[][] positions) {
        int[][] masks = new int[boardSize][boardSize];
        int n = pieces.length;
        for (int i = 0; i < n; i++) {
            int x = positions[i][0] - 1, y = positions[i][1] - 1;
            int maskForThisPiece = 1 << i;
            if (pieces[i].equals("rook") || pieces[i].equals("queen")) {
                for (int j = 0; j < boardSize; j++) {
                    masks[x][j] |= maskForThisPiece;
                    masks[j][y] |= maskForThisPiece;
                }
            }
            if (pieces[i].equals("bishop") || pieces[i].equals("queen")) {
                int d1 = x - y, d2 = x + y;
                for (int x1 = 0; x1 < boardSize; x1++) {
                    int y1 = x1 - d1, y2 = d2 - x1;
                    if (y1 >= 0 && y1 < boardSize) masks[x1][y1] |= maskForThisPiece;
                    if (y2 >= 0 && y2 < boardSize) masks[x1][y2] |= maskForThisPiece;
                }
            }
            if (pieces[i].equals("knight")) {
                for (int[] knightMove : knightMoves) {
                    int x2 = x + knightMove[0], y2 = y + knightMove[1];
                    if (x2 >= 0 && x2 < boardSize && y2 >= 0 && y2 < boardSize) masks[x2][y2] |= maskForThisPiece;
                }
                masks[x][y] |= maskForThisPiece;
            }
            if (pieces[i].equals("king")) {
                for (int dx = -1, x2 = x - 1; dx <= 1; dx++, x2++) {
                    if (x2 < 0 || x2 >= boardSize) continue;
                    for (int dy = -1, y2 = y - 1; dy <= 1; dy++, y2++) {
                        if (y2 >= 0 && y2 < boardSize) masks[x2][y2] |= maskForThisPiece;
                    }
                }
            }
        }

        int[] maskCount = new int[1 << n];
        int totalMasks = 0;
        int[] totalForBits = new int[n];

        for (int[] arr : masks)
            for (int mask : arr)
                if (maskCount[mask]++ == 0 && mask != 0) {
                    totalMasks++;
                    for (int i = 0; i < n; i++) if ((mask >> i & 1) == 1) totalForBits[i]++;
                }

        int[] counts = new int[totalMasks];
        int[][] masksForBits = new int[n][];
        for (int i = 0; i < n; i++) masksForBits[i] = new int[totalForBits[i]];


        int[] posForBits = new int[n];
        for (int mask = 1, pos = 0; pos < totalMasks; mask++) {
            if (maskCount[mask] != 0) {
                for (int i = 0; i < n; i++) if ((mask >> i & 1) == 1) masksForBits[i][posForBits[i]++] = pos;
                counts[pos++] = maskCount[mask];
            }
        }
        if (DEBUG) {
            System.out.println(totalMasks);
            for (int i = 0; i < n; i++) {
                System.out.println(i + " " + masksForBits[i].length);
            }
        }

        return dfs(0, n, counts, masksForBits);
    }

    private static long dfs(int i, int n, int[] maskCounts, int[][] masksForBits) {
        if (i == n) return 1;
        long ans = 0;
        for (int idx : masksForBits[i]) {
            if (maskCounts[idx] == 0) continue;
            ans += (maskCounts[idx]--) * dfs(i + 1, n, maskCounts, masksForBits);
            maskCounts[idx]++;
        }
        return ans;
    }
}

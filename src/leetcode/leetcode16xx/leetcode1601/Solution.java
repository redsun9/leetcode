package leetcode.leetcode16xx.leetcode1601;

public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int selfLoops = 0;
        int edgesNumber = 0;
        for (int[] request : requests) {
            if (request[0] == request[1]) selfLoops++;
            else edgesNumber++;
        }
        int[][] edges = new int[edgesNumber][2];
        for (int[] request : requests) {
            if (request[0] != request[1]) edges[--edgesNumber] = request;
        }
        for (int numbits = edges.length; numbits >= 2; numbits--) {
            if (dfs(numbits, 0, edges.length, n, edges)) return selfLoops + numbits;
        }
        return selfLoops;
    }

    //iterate through all integers with numbits bits set to 1
    private static boolean dfs(int numbits, int acc, int prevBit, int n, int[][] edges) {
        if (numbits == 0) {
            int[] count = new int[n];
            int nonZero = 0;
            for (int i = 0; i < edges.length; i++) {
                if ((acc & (1 << i)) != 0) {
                    int prev = count[edges[i][0]]--;
                    if (prev == 0) nonZero++;
                    else if (prev == 1) nonZero--;

                    prev = count[edges[i][1]]++;
                    if (prev == 0) nonZero++;
                    else if (prev == -1) nonZero--;
                }
            }
            return nonZero == 0;
        }
        for (int bit = numbits - 1; bit < prevBit; bit++) {
            if (dfs(numbits - 1, acc | (1 << bit), bit, n, edges)) return true;
        }
        return false;
    }
}

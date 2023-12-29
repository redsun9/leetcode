package cses_fi.task1750;

/*
    You are playing a game consisting of n planets. Each planet has a teleporter to another planet (or the planet itself).
    Your task is to process q queries of the form: when you begin on planet x and travel through k teleporters, which planet will you reach?
 */
public class Solution {
    public static int[] planetQueries(int[] teleports, int[][] queries) {
        int n = teleports.length;
        int maxNeeded = 0;
        for (int[] query : queries) maxNeeded = Math.max(maxNeeded, query[1]);

        int maxPower2 = 32 - Integer.numberOfLeadingZeros(maxNeeded);

        int[][] dest = new int[maxPower2][n];
        dest[0] = teleports;
        for (int k = 1; k < maxPower2; k++) for (int i = 0; i < n; i++) dest[k][i] = dest[k - 1][dest[k - 1][i] - 1];

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], k = queries[i][1];
            int bit = 0;
            while (k != 0) {
                if ((k & 1) != 0) x = dest[bit][x - 1];
                k >>= 1;
                bit++;
            }
            ans[i] = x;
        }
        return ans;
    }
}

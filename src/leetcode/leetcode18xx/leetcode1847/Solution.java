package leetcode.leetcode18xx.leetcode1847;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, Comparator.comparingInt(r -> r[1]));
        TreeSet<Integer> set = new TreeSet<>();
        int[][] pqQueries = new int[queries.length][2];
        for (int i = queries.length - 1; i >= 0; i--) {
            pqQueries[i][0] = queries[i][1];
            pqQueries[i][1] = i;
        }
        Arrays.sort(pqQueries, Comparator.comparingInt(q -> q[0]));
        int[] ans = new int[queries.length];
        int pos = rooms.length - 1;
        for (int i = queries.length - 1; i >= 0; i--) {
            int minSize = pqQueries[i][0];
            int queryIndex = pqQueries[i][1];
            int preferred = queries[queryIndex][0];
            while (pos >= 0 && rooms[pos][1] >= minSize) set.add(rooms[pos--][0]);
            Integer queryResult = null;
            Integer floor = set.floor(preferred);
            if (floor != null) queryResult = floor;
            Integer ceiling = set.ceiling(preferred);
            if (queryResult == null) queryResult = ceiling;
            else if (ceiling != null) {
                queryResult = preferred - floor <= ceiling - preferred ? floor : ceiling;
            }
            ans[queryIndex] = queryResult != null ? queryResult : -1;
        }
        return ans;
    }
}

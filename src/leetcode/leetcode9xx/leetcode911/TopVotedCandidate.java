package leetcode.leetcode9xx.leetcode911;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TopVotedCandidate {
    private final int[][] tmp;
    private final int n;

    public TopVotedCandidate(int[] persons, int[] times) {
        n = persons.length;
        tmp = new int[n][3];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = times[i];
            tmp[i][1] = i;
            tmp[i][2] = persons[i];
        }
        Arrays.sort(tmp, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVote = 0, winner = 0;
        for (int[] vote : tmp) {
            int nVote = map.compute(vote[2], (k, v) -> v == null ? 1 : v + 1);
            if (nVote >= maxVote) {
                maxVote = nVote;
                winner = vote[2];
            }
            vote[2] = winner;
        }
    }

    public int q(int t) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (tmp[mid][0] <= t) lo = mid + 1;
            else hi = mid;
        }
        return tmp[lo - 1][2];
    }
}

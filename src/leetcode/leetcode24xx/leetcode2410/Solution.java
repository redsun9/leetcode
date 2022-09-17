package leetcode.leetcode24xx.leetcode2410;

import java.util.Arrays;

public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for (int i = players.length - 1, j = trainers.length - 1; i >= 0 && j >= 0; i--) {
            if (players[i] <= trainers[j]) {
                ans++;
                j--;
            }
        }
        return ans;
    }
}

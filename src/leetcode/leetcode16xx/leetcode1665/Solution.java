package leetcode.leetcode16xx.leetcode1665;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[1] - task[0]));
        int energyLeft = 0;
        for (int[] task : tasks) {
            energyLeft = Math.max(energyLeft + task[0], task[1]);
        }
        return energyLeft;
    }
}

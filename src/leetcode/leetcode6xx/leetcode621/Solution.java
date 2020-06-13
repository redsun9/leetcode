package leetcode.leetcode6xx.leetcode621;

import java.util.Arrays;

public class Solution {
    //find number of largest groups
    //if A,B - largest group then ABXX ABXX AB (3-1)*(2+1) + (25-23)
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) i--;
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }
}

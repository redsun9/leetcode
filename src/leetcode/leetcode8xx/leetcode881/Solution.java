package leetcode.leetcode8xx.leetcode881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                n--;
                i++;
            }
            j--;
        }
        return n;
    }
}

package leetcode.leetcode13xx.leetcode1395;

public class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k] || rating[i] < rating[j] && rating[j] < rating[k])
                        count++;
                }
            }
        }
        return count;
    }
}

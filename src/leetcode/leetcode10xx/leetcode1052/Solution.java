package leetcode.leetcode10xx.leetcode1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int total = 0;
        if (minutes >= n) {
            for (int customer : customers) total += customer;
            return total;
        }
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) total += customers[i];
        }
        int curr = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) curr += customers[i];
        }
        int max = curr;
        for (int i = minutes, j = 0; i < n; i++, j++) {
            curr += (grumpy[i] == 1 ? customers[i] : 0) - (grumpy[j] == 1 ? customers[j] : 0);
            max = Math.max(max, curr);
        }
        return total + max;
    }
}

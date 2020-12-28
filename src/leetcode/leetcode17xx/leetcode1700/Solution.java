package leetcode.leetcode17xx.leetcode1700;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] count = {0, 0};
        for (int a : students)
            count[a]++;
        int k = 0;
        while (k < n && count[sandwiches[k]] > 0) count[sandwiches[k++]]--;
        return n - k;
    }
}

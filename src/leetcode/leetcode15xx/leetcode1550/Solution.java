package leetcode.leetcode15xx.leetcode1550;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int i = 0;
        int count = 0;
        while (i < n && count != 3) {
            if ((arr[i++] & 1) == 0) count = 0;
            else count++;
        }
        return count == 3;
    }
}

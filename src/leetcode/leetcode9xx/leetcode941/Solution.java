package leetcode.leetcode9xx.leetcode941;

public class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3 || arr[0] >= arr[1]) return false;
        int i = 2;
        while (i < n && arr[i - 1] < arr[i]) i++;
        if (i == n) return false;
        while (i < n && arr[i - 1] > arr[i]) i++;
        return i == n;
    }
}

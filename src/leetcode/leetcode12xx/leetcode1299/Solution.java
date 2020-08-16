package leetcode.leetcode12xx.leetcode1299;

public class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int tmp = Math.max(max, arr[i]);
            arr[i] = max;
            max = tmp;
        }
        arr[n - 1] = -1;
        return arr;
    }
}

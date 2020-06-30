package leetcode.leetcode8xx.leetcode801;

public class Solution {
    public int minSwap(int[] a, int[] b) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] >= b[i] || b[i - 1] >= a[i]) {
                swapRecord++;
            } else if (a[i - 1] >= a[i] || b[i - 1] >= b[i]) {
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }
}

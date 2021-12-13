package leetcode.leetcode21xx.leetcode2100;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = k, left = 0, right = k, leftFail = -1, rightFail = k - 1; i < n - k; ) {
            while (left < i) {
                if (arr[left] < arr[left + 1]) {
                    leftFail = left;
                    left++;
                    break;
                }
                left++;
            }
            while (i + k > right) {
                if (arr[right] > arr[right + 1]) {
                    rightFail = right;
                    right++;
                    break;
                }
                right++;
            }
            if (i - leftFail > k && rightFail < i) ans.add(i);
            i = max(leftFail + k, rightFail, i) + 1;
            left = Math.max(left, i - k);
            right = Math.max(right, i);
        }
        return ans;
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}

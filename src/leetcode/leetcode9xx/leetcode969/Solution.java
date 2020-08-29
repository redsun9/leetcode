package leetcode.leetcode9xx.leetcode969;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] a) {
        List<Integer> ans = new LinkedList<>();
        for (int x = a.length; x > 0; x--) {
            int i = x - 1;
            while (a[i] != x) i--;
            if (i + 1 != x) {
                reverse(a, i + 1);
                reverse(a, x);
            }
            ans.add(i + 1);
            ans.add(x);
        }
        return ans;
    }

    private static void reverse(int[] a, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}

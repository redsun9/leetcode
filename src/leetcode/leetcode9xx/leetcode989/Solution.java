package leetcode.leetcode9xx.leetcode989;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] a, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int over = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int tmp = a[i] + over + k % 10;
            ans.addFirst(tmp % 10);
            over = tmp / 10;
            k /= 10;
        }
        over += k;
        while (over != 0) {
            ans.addFirst(over % 10);
            over /= 10;
        }
        return ans;
    }
}

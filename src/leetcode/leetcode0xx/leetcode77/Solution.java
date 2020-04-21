package leetcode.leetcode0xx.leetcode77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static void combine(int n, int k, int[] tmp, List<List<Integer>> ans) {
        if (k == 0 || n == k) {
            for (int i = k; i > 0; i--) {
                tmp[i - 1] = i;
            }
            ArrayList<Integer> subAns = new ArrayList<>(tmp.length);
            for (int a : tmp) {
                subAns.add(a);
            }
            ans.add(subAns);
        } else {
            while (n >= k) {
                tmp[k - 1] = n;
                combine(n - 1, k - 1, tmp, ans);
                n--;
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) return Collections.emptyList();
        int[] tmp = new int[k];
        List<List<Integer>> ans = new LinkedList<>();
        combine(n, k, tmp, ans);
        return ans;
    }
}

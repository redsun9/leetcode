package leetcode.leetcode9xx.leetcode967;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> prev = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= n; i++) {
            List<Integer> next = new ArrayList<>(prev.size() * 2);
            for (Integer a : prev) {
                int lastDigit = a % 10;
                if (lastDigit - k >= 0) next.add(a * 10 + lastDigit - k);
                if (k != 0 && lastDigit + k <= 9) next.add(a * 10 + lastDigit + k);
            }
            prev = next;
        }
        int[] ans = new int[prev.size()];
        for (int i = 0; i < prev.size(); i++) {
            ans[i] = prev.get(i);
        }
        return ans;
    }
}

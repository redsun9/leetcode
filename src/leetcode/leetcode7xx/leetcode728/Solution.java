package leetcode.leetcode7xx.leetcode728;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            boolean ok = true;
            for (int tmp = i; tmp > 0; tmp /= 10) {
                int digit = tmp % 10;
                if (digit == 0 || i % digit != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans.add(i);
        }
        return ans;
    }
}

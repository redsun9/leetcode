package leetcode.leetcode3xx.leetcode386;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int tmp = 1;
        do {
            while (tmp <= n) {
                ans.add(tmp);
                tmp *= 10;
            }
            tmp /= 10;
            while (tmp % 10 == 9) tmp /= 10;
            tmp++;
        } while (tmp != 1);
        return ans;
    }
}

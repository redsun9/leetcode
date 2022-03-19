package leetcode.leetcode21xx.leetcode2197;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int gcd, last;
        for (int num : nums) {
            ans.add(num);
            while (ans.size() >= 2 && (gcd = gcd(ans.get(ans.size() - 1), ans.get(ans.size() - 2))) != 1) {
                last = ans.get(ans.size() - 1) / gcd * ans.get(ans.size() - 2);
                ans.remove(ans.size() - 1);
                ans.remove(ans.size() - 1);
                ans.add(last);
            }
        }
        return ans;
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}

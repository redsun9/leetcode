package leetcode.leetcode12xx.leetcode1238;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        int capacity = 1 << n;
        List<Integer> ans = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            ans.add(i ^ (i >> 1) ^ start);
        }
        return ans;
    }
}

package leetcode.leetcode0xx.leetcode89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        int capacity = 1 << n;
        int mask = capacity - 1;
        List<Integer> ans = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) ans.add(i ^ (i >> 1));
        return ans;
    }
}

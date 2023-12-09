package leetcode.leetcode29xx.leetcode2951;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        int n = mountain.length - 1;
        for (int i = 1; i < n; i++) if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) ans.add(i);
        return ans;
    }
}

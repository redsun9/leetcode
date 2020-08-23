package leetcode.leetcode15xx.leetcode1557;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isNotRoot = new boolean[n];
        for (List<Integer> edge : edges) {
            isNotRoot[edge.get(1)] = true;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!isNotRoot[i]) ans.add(i);
        }
        return ans;
    }
}

package leetcode.leetcode15xx.leetcode1560;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int roundsNumber = rounds.length - 1;
        for (int i = rounds[0]; i <= rounds[roundsNumber]; ++i)
            ans.add(i);
        if (ans.size() > 0) return ans;
        for (int i = 1; i <= rounds[roundsNumber]; ++i)
            ans.add(i);
        for (int i = rounds[0]; i <= n; ++i)
            ans.add(i);
        return ans;
    }
}

package leetcode.leetcode12xx.leetcode1237;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final int maxCoord = 1000;

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int i = 1, j = maxCoord;
        LinkedList<List<Integer>> ans = new LinkedList<>();
        while (i <= maxCoord && j >= 1) {
            int val = customfunction.f(i, j);
            if (val == z) ans.add(List.of(i++, j--));
            else if (val > z) j--;
            else i++;
        }
        return ans;
    }
}

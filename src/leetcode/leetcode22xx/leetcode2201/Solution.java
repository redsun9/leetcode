package leetcode.leetcode22xx.leetcode2201;

import java.util.HashMap;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashMap<Cell, Integer> leftParts = new HashMap<>();
        HashMap<Cell, Cell> parts = new HashMap<>();
        for (int[] artifact : artifacts) {
            Cell parent = new Cell(artifact[0], artifact[1]);
            leftParts.put(parent, (artifact[2] - artifact[0] + 1) * (artifact[3] - artifact[1] + 1));
            for (int x = artifact[0]; x <= artifact[2]; x++) {
                for (int y = artifact[1]; y <= artifact[3]; y++) {
                    parts.put(new Cell(x, y), parent);
                }
            }
        }
        int ans = 0;
        for (int[] artifact : dig) {
            Cell parent = parts.put(new Cell(artifact[0], artifact[1]), null);
            if (parent == null) continue;
            if (leftParts.compute(parent, (k, v) -> v == 1 ? null : v - 1) == null) ans++;
        }
        return ans;
    }

    private record Cell(int x, int y) {
    }
}
